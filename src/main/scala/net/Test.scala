package net

// author: Travis Brown from
//  https://meta.plasm.us/posts/2015/07/11/roll-your-own-scala/
object Test {

	trait Functor[F[_]] {
	  def map[A, B](fa: F[A])(f: A => B): F[B]
	}

	implicit val listFunctor: Functor[List] = new Functor[List] {
	  def map[A, B](fa: List[A])(f: A => B): List[B] = fa.map(f)
	}
	
	type StringOr[A] = Either[String, A]

	implicit val stringOrXFunctor: Functor[StringOr] = new Functor[StringOr] {
		def map[A, B](fa: StringOr[A])(f: A => B): StringOr[B] = fa.right.map(f)
	}

	// implicit def eitherFunctor[E] = {
	// 	type EOr[A] = Either[E, A]

	// 	new Functor[EOr] {
	// 		def map[A, B](fa: EOr[A])(f: A => B): EOr[B] = fa.right.map(f)
	// 	}
	// }

	implicit def eitherFunctor[E]: Functor[({ type L[X] = Either[E, x] })#L] = 
		new Functor[({ type L[x] = Either[E, x] })#L] {
			def map[A,]
		}

}