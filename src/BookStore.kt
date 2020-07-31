import kotlin.math.abs
import kotlin.math.round

/**
# Book Store

To try and encourage more sales of different books from a popular 5 book
series, a bookshop has decided to offer discounts on multiple book purchases.

One copy of any of the five books costs $8.

If, however, you buy two different books, you get a 5%
discount on those two books.

If you buy 3 different books, you get a 10% discount.

If you buy 4 different books, you get a 20% discount.

If you buy all 5, you get a 25% discount.

Note: that if you buy four books, of which 3 are
different titles, you get a 10% discount on the 3 that
form part of a set, but the fourth book still costs $8.

Your mission is to write a piece of code to calculate the
price of any conceivable shopping basket (containing only
books of the same series), giving as big a discount as
possible.

For example, how much does this basket of books cost?

- 2 copies of the first book
- 2 copies of the second book
- 2 copies of the third book
- 1 copy of the fourth book
- 1 copy of the fifth book

One way of grouping these 8 books is:

- 1 group of 5 --> 25% discount (1st,2nd,3rd,4th,5th)
- +1 group of 3 --> 10% discount (1st,2nd,3rd)

This would give a total of:

- 5 books at a 25% discount
- +3 books at a 10% discount

Resulting in:

- 5 x (8 - 2.00) == 5 x 6.00 == $30.00
- +3 x (8 - 0.80) == 3 x 7.20 == $21.60

For a total of $51.60

However, a different way to group these 8 books is:

- 1 group of 4 books --> 20% discount  (1st,2nd,3rd,4th)
- +1 group of 4 books --> 20% discount  (1st,2nd,3rd,5th)

This would give a total of:

- 4 books at a 20% discount
- +4 books at a 20% discount

Resulting in:

- 4 x (8 - 1.60) == 4 x 6.40 == $25.60
- +4 x (8 - 1.60) == 4 x 6.40 == $25.60

For a total of $51.20

And $51.20 is the price with the biggest discount.
 */

fun main(){

    discountCalculator()
}
// note: this only covers the first test case
fun discountCalculator(){
    val originalList= listOf(2,2,2,1,1)
    var firstDiscount=0.0
    var secondDiscount=0.0
    /*
    we do this in order to efficiently find the correct list grouping whether the size is odd/even
     */
    val endIndex=abs(originalList.size/2)
    val firstSubset = originalList.subList(0,endIndex)
    val secondSubset =originalList.subList(endIndex,originalList.size)
    var spillOver =0
    var secondOverflow=0 // TODO: handle the second overflow
    when {
        firstSubset.sum()>5 -> {
            spillOver= firstSubset.sum()-5
            when {
                firstSubset.sum()-spillOver==5 -> {
                    firstDiscount=(8-(0.25*8))*5

                }
                firstSubset.sum()-spillOver==4->{
                    firstDiscount=(8-(0.2*8))*4
                }
                firstSubset.sum()-spillOver==3->{
                    firstDiscount=(8-(0.2*8))*3
                }
            }
        }
        firstSubset.sum()==5 -> {
            firstDiscount=(8-(0.25*8))*5
        }
        firstSubset.sum()==4->{
            firstDiscount=(8-(0.2*8))*4
        }
        firstSubset.sum()==3->{
            firstDiscount=(8-(0.2*8))*3
        }

    }

    when{
        secondSubset.sum()+spillOver==5 -> {

            secondDiscount=(8-(0.25*8))*5
        }
        secondSubset.sum()+spillOver==4->{
            secondDiscount=(8-(0.2*8))*4
        }
        secondSubset.sum()+spillOver==3->{
            secondDiscount=(8-(0.2*8))*3
        }
    }


    print("Total discount ${round(firstDiscount+secondDiscount)}")

}

