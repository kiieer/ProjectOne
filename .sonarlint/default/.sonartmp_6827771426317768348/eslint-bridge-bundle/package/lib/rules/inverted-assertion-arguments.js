"use strict";
/*
 * SonarQube JavaScript Plugin
 * Copyright (C) 2011-2022 SonarSource SA
 * mailto:info AT sonarsource DOT com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
// https://sonarsource.github.io/rspec/#/rspec/S3415
Object.defineProperty(exports, "__esModule", { value: true });
exports.rule = void 0;
const utils_1 = require("../utils");
const ASSERT_FUNCTIONS = [
    'equal',
    'notEqual',
    'strictEqual',
    'notStrictEqual',
    'deepEqual',
    'notDeepEqual',
    'closeTo',
    'approximately',
];
exports.rule = {
    meta: {
        schema: [
            {
                // internal parameter for rules having secondary locations
                enum: ['sonar-runtime'],
            },
        ],
    },
    create(context) {
        const testCases = [];
        return {
            CallExpression(node) {
                if (utils_1.Mocha.isTestCase(node)) {
                    testCases.push(node);
                    return;
                }
                if (testCases.length > 0) {
                    checkInvertedArguments(node, context);
                }
            },
            'CallExpression:exit': (node) => {
                if (utils_1.Mocha.isTestCase(node)) {
                    testCases.pop();
                }
            },
        };
    },
};
function checkInvertedArguments(node, context) {
    const args = extractAssertionsArguments(node);
    if (args) {
        const [actual, expected] = args;
        if ((0, utils_1.isLiteral)(actual) && !(0, utils_1.isLiteral)(expected)) {
            const message = (0, utils_1.toEncodedMessage)('Swap these 2 arguments so they are in the correct order: actual value, expected value.', [actual], ['Other argument to swap.']);
            context.report({
                node: expected,
                message,
            });
        }
    }
}
function extractAssertionsArguments(node) {
    var _a, _b;
    return (_b = (_a = extractAssertArguments(node)) !== null && _a !== void 0 ? _a : extractExpectArguments(node)) !== null && _b !== void 0 ? _b : extractFailArguments(node);
}
function extractAssertArguments(node) {
    if ((0, utils_1.isMethodCall)(node) && node.arguments.length > 1) {
        const { callee: { object, property }, arguments: [actual, expected], } = node;
        if ((0, utils_1.isIdentifier)(object, 'assert') && (0, utils_1.isIdentifier)(property, ...ASSERT_FUNCTIONS)) {
            return [actual, expected];
        }
    }
    return null;
}
function extractExpectArguments(node) {
    if (node.callee.type !== 'MemberExpression') {
        return null;
    }
    let { object, property } = node.callee;
    if (!(0, utils_1.isIdentifier)(property, 'equal', 'eql', 'closeTo')) {
        return null;
    }
    while (object.type === 'MemberExpression') {
        object = object.object;
    }
    if (object.type === 'CallExpression' && (0, utils_1.isIdentifier)(object.callee, 'expect')) {
        return [object.arguments[0], node.arguments[0]];
    }
    return null;
}
function extractFailArguments(node) {
    if ((0, utils_1.isMethodCall)(node) && node.arguments.length > 1) {
        const { callee: { object, property }, arguments: [actual, expected], } = node;
        if ((0, utils_1.isIdentifier)(object, 'assert', 'expect', 'should') && (0, utils_1.isIdentifier)(property, 'fail')) {
            return [actual, expected];
        }
    }
    return null;
}
//# sourceMappingURL=inverted-assertion-arguments.js.map