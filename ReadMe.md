Assumptions:
1. To implement only BookService implementation and not to implement the BookRepository using database.
2. Added WordProcessor class to match the words by space and comma. This is because the acceptance criteria has the below data for 'BOOK-WILL987' when we get the summary. After the word 'outside', we should not add a comma to it.

[BOOK-WILL987] The Wind In The Willows - With the arrival of spring and fine weather outside...

And NOT

[BOOK-WILL987] The Wind In The Willows - With the arrival of spring and fine weather outside,...
3. Implemented tests in junit 5