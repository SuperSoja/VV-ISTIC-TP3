# Detecting test smells with PMD

In folder [`pmd-documentation`](../pmd-documentation) you will find the documentation of a selection of PMD rules designed to catch test smells.
Identify which of the test smells discussed in classes are implemented by these rules.

Use one of the rules to detect a test smell in one of the following projects:

- [Apache Commons Collections](https://github.com/apache/commons-collections)
- [Apache Commons CLI](https://github.com/apache/commons-cli)
- [Apache Commons Math](https://github.com/apache/commons-math)
- [Apache Commons Lang](https://github.com/apache/commons-lang)

Discuss the test smell you found with the help of PMD and propose here an improvement.
Include the improved test code in this file.

## Answer

1)

 	The class 'TestOption' might be a test class, but it contains no test cases.

2)

Voici la ruleset :

J'ai exécuté la commande suivante :

./run.sh pmd -d "/home/yehidjineri/Documents/M2/V&V/CLI/commons-cli/src/test/java/org/apache/commons/cli" -f html -R "rulesets/java/junit.xml" > rapport.html

cela exécute la ruleset de Junit dans le code de CLI et a trouvé ce vrai positif :
la règle est : TestClassWithoutTestCases


private static class TestOption extends Option {
        private static final long serialVersionUID = 1L;

        TestOption(final String opt, final boolean hasArg, final String description) throws IllegalArgumentException {
            super(opt, hasArg, description);
        }

        @Override
        public boolean addValue(final String value) {
            addValueForProcessing(value);
            return true;
        }
}

Le problème est que cette classe est nommée en commencant par Test, mais qu'elle possède une fonction qui ne porte pas un nom commencant par Test.
