# On assertions

Answer the following questions:

1. The following assertion fails `assertTrue(3 * .4 == 1.2)`. Explain why and describe how this type of check should be done.

2. What is the difference between `assertEquals` and `assertSame`? Show scenarios where they produce the same result and scenarios where they do not produce the same result.

3. In classes we saw that `fail` is useful to mark code that should not be executed because an exception was expected before. Find other uses for `fail`. Explain the use case and add an example.

4. In JUnit 4, an exception was expected using the `@Test` annotation, while in JUnit 5 there is a special assertion method `assertThrows`. In your opinion, what are the advantages of this new way of checking expected exceptions?

## Answer

1)
Il faut mettre : Assert.assertEquals(3 * .4, 1.2, 0.0f) parce qu'il faut prendre en compte une marge d'erreur étant donné que les nombres à virgule ne sont pas nécéssairement juste (car infini)

2)

assertEquals utilise la méthode equals() (qu'on doit override dans notre classe pour vraiment comparer 2 instances) pour comparer 2 objets. Alors que assertSame utilise l'opérateur ==.

3)

Fail est bien car il nous permet de savoir ou il peut y avoir des erreurs, et donc, de faire des tests de non régression ici.
Exemple, une division par zero.

return 5/unevariable;

4)

C'est plus clair, car cela permet de comprendre plus rapidement ce que le test vérifie.