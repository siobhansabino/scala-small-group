A good chunk of the below is taken from The Big Book: _Programming in Scala, Second Edition_. Except for the spelling errors, that's just me.

# Traversable

* Covered in The Big Book on pages 502–507

> At the top of the collection hierarchy is trait `Traversable`. It sonly abstract operation is `foreach`.
>
> ```scala
> def foreach[U](f: Elem => U)
> ```
>
> Collection classes implementating `Traversable` just need to define this moethod; all other methods can be inherited from `Traversable`.

## Group of concrete functions supplied

* Addition (`++`)
* Map operations (`map`, `flatMap`, `collect`)
* Converstions (`toIterable`, `toList`, `toSet`, `toMap`, etc)
* Copying operations (`copyToBuffer`, `copyToArray`)
* Size operations (`isEmpty`, `nonEmpty`, `size`, `hasDefiniteSize`)
* Element retrieval operations (`head`, `last`, `headOption`, `lastOption`, `find`)
* Subcollection retrieval operations (`tail`, `take`, `drop`, `filter`, etc)
* Subdivision operations (`splitAt`, `partition`, etc)
* Element tests (`exists`, `forall`, `count`)
* Folds (`foldLeft`, `foldRight`, `reduceLeft`, `reduceRight`, etc)
* Specific folds (`sum`, `product`, `min`, `max`)
* String operations (`mkString`, etc)
* View operations

# Ordered

* Covered in The Big Book on pages 224–225

> The trait is called `Ordered`. To use it, you replace all of the individual comparison methods with a single `compare` method. The `Ordered` trait then defines `<`, `>`, `<=`, and `>=` for you in terms of this one method. Thus, trait `Ordered` allows you to enrich a class with comparison methods by implementing only one method, `compare`.

# Iterable

* Covered in The Big Book on pages 507–511

> All methods in this trait [`Iterable`] are defined in terms of an abstract method, `iterator`, which yields the collection's elements one by one. The `foreach` method from trait `Traversable` is implemented in `Iterable` in terms of `iterator`. Here is the actual implementation:
>
> ```scala
> def foreach[U](f: Elem => U): Unit = {
>     val it = iterator
>     while (it.hasNext) f(it.next())
> }
> ```
>
> Quite a few subclasses of `Iterable` override this standard implementation of `foreach` in `Iterable`, because they can provide a more efficient implementation. Remember that `foreach` is the basis of the implementation of all operations in `Traversable`, so its performance matters.

# Sequence

* Covered in The Big Book on pages 511–516

> The `Seq` trait represents sequences. A sequence is a kind of iterable that has a `length` and whose elements have fixed index positions, starting from `0`.

## Group of concrete functions supplied

* Indexing and length operations (`apply`, `length`, etc)
* Index search operations (`indexOf`, `indexWhere`, etc)
* Addition operations (`+:`, `:+`, `padTo`)
* Update operations (`updated`, `patch`)
* Sorting operations (`sorted`, `sortWith`, `sortBy`)
* Reversal operations (`reverse`, `reverseIterator`, `reverseMap`)
* Comparison operations (`startsWith`, `endsWith`, `contains`, etc)
* Multiset operations (`intersect`, `diff`, `union`, `distinct`)

