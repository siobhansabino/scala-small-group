A good chunk of the below is taken from The Big Book: _Programming in Scala, Second Edition_. Except for the spelling errors, that's just me.

# Background

> Occasionally, you may need to process a small, special-purpose language. For example, you may need to read configuration files for your software, and you want to make them easier to modify by hand than XML. ALternatively, maybe you want to support an input language in your program, such as search terms with boolean operators (computer, find me a movie "with 'space ships' and without 'love stories'"). Whatever the reason, you are going to need a parser. You need a way to convert the input language into some data structure your software can process.
>
> Essentially, you have only a few choices. One choice is to roll your own parser (and lexcial analyzer). If you are not an expert, this is hard. If you are an expert, it is still time consuming.
>
> An alternative choice is to use a parser generator. […]
>
> This chapter presents a third alternative. Instead of using the standalone domain specific language of a parser generator, you will use an _internal domain specific language_, or internal DSL for short. The internal DSL will consist of a library of _parser combinators_ — functions and operators defined in Scala that will serve as building blocks for parsers. These building blocks will map one to one to the constructions of a context-free grammar, to make them easy to understand.

# Arithmetic expressions example

> Say you want to construct a parser for arithmetic