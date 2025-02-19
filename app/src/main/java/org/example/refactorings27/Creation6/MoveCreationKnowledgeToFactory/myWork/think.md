NodeFactory instance must be accessible to both Parser clients and the StringParser.
Why ?
1.  can’t simply move this code into the NodeFactory because clients of this code are clients of the parser which call Parser methods like setNodeDecoding(…) to configure the parser for a given parse.

2. NodeFactory is not even visible to parser clients: it is instantiated by StringParser, which itself is not visible to parser clients.

=============
How ?
1. Extract Class
* move the shouldDecodeNodes field, getter, and setter  to new class NodeFactory
* replaces the shouldDecodeNodes field, getter, and setter with a StringNodeParsingOption field and its getter and setter
* clients(DecodingNodeTest) now turn StringNode decoding on by instantiating and
  configuring a StringNodeParsingOption instance and passing it to the parser
2. The StringParser now obtains the state of the StringNode decoding option by  means of the new class

3. Inline Class （merge NodeFactory with StringNodeParsingOption. ）