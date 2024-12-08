// jest.config.js
module.exports = {
    preset: 'jest-preset-angular',
    setupFilesAfterEnv: ['<rootDir>/setup-jest.ts'],
    testEnvironment: 'jsdom',
    transform: {
    '^.+\\.(ts|js|html)$': 'ts-jest',
    },
    moduleNameMapper: {
    '^src/(.*)$': '<rootDir>/src/$1',
    },
    globals: {
    'ts-jest': {
        tsconfig: '<rootDir>/tsconfig.spec.json',
        stringifyContentPathRegex: '\\.html$',
    },
    },
    coverageReporters: ['html', 'lcov', 'text-summary'],
};