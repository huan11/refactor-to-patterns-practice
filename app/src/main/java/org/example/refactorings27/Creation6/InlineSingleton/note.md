Inline Class:
an absorbing class is one that will take on the responsibilities of
the inlined Singleton.

1. Declare the Singleton’s public methods on your absorbing class
2. Make the new methods delegate back to the Singleton
3. remove any “static” designations they may have (in the absorbing class).

   If your absorbing class is itself a Singleton, you’ll want to keep the “static”
   designations for the method
4. Change route
5. Move Method and Move Field
6. Delete the Singleton.