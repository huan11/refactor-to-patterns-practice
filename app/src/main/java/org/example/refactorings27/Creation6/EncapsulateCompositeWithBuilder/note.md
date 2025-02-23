Three reasons to use Builder：
1. Reduces the repetitive and error-prone nature of Composite creation.
2. Creates a loose coupling between client and Composite.
3. Allows for different representations of the encapsulated Composite or
   complex object.


The way to produce builder： TDD
1. Create a builder
2. Make the builder capable of building children. 
3. If the Composite-construction code you’re replacing sets attributes or
   values on nodes, make the builder capable of setting those attributes and
   values.
4. Reflect on how simple your builder is for clients to use, and then make it
   simpler.
5. Refactor your Composite-construction code to use the new builder. This
   involves making your client code what is known in Design Patterns as a
   Builder: Client and Builder: Director.