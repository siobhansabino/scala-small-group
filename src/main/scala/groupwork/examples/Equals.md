The below is adapted from The Big Book, beginning on pg 670. The text and ordering has been changed for the purpose of this class.

# Part 1: `hashCode`

1. Determine which fields are relevant — if you're going to use them for determining equality, you'll want them to be part of the hash code.
2. Create your function `override def hashCode: Int`
3. Start on the inside of your relevant fields list and add 41 to the first value's hash code: `41 + a.hashCode`
4. Working your way out, you'll multiply the current value by 41 and then add the next value's hash code.
5. Repeat until done.

_Example for a three-field check_:

```scala
override def hashCode: Int = 
    41 * (
        41 * (
            41 + a.hashCode
        ) + b.hashCode
    ) + c.hashCode
```

# Part 2: `equals`

## `canEqual`: the prequel

1. Create your function `def canEqual(other: Any): Boolean`
2. If the input object is of the type your class is, return `true`.
   * _Example_: if the class you're working with is `GraphObject`, then `def canEqual(other: Any): Boolean = other.isInstanceOf[GraphObject]`

## `equals`: the reckoning

1. Create your function `override def equals(other: Any): Boolean`
2. Write the body as a single `match` statement: `override def equals(other: Any): Boolean = other match { ... }`
3. The first `case` will be a typed pattern for the class you're working with.
   * _Example_: if the class you're working with is `GraphObject`, then `case that: GraphObject => `
4. The second `case` will catch everything else and return false: `case _ => false`
5. Return to the first `case` which can now be finished. You're going to logical-and a bunch of stuff together as outlined below, creating one expression for the return value.
   1. If your class has a superclass, invoke it first: `super.equals(that) &&`
   2. If you don't have a superclass, invoke `canEqual`: `(this.canEqual(that)) &&`
      * A superclass should do this for you, which is why you invoke `super.equals` or `this.canEqual`, not both.
   3. Continue the expression by logical-anding the remaining relevant fields together.
      * This should match the fields in the `hashCode` implementation.

_Example for a three field check using a super class_:

```scala
override def equals(other: Any): Boolean = other match {
    case that: GraphObject => super.equals(that) &&
    	a == that.a &&
    	b == that.b &&
    	c == that.c
    case _ => false
}
```

_Example for a three field check using a `canEqual` class:_

```scala
override def equals(other: Any): Boolean = other match {
    case that: GraphObject => this.canEqual(that) &&
    	a == that.a &&
    	b == that.b &&
    	c == that.c
    case _ => false
}
```

