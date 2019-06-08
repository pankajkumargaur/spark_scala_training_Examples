package scala_concepts_examples

/**
  * Created by Pankaj Gaur on 08-06-2019.
  */


// functional aspects and object oriented aspects
// case match expression and extract values pattern matching -- value binding and default binding

object Problem1_Scala_Refresher {

  def main(args: Array[String]) {

    // match expressions
    val x = 10; val y = 20
    val max = x > y match {
           case true =>  x
           case false => y
        }
    println(max)

    //At least one of the pattern should match else it will throw error: to avoid that default or wildcard matching is an option:
    //Value binding example; value will be binded with X or assigned to X

    val status = 404
    val msg = status match {
       case 500 => "Critical Error"
       case 200 => "Success"
       case x => "Unknown"
         }
    println(msg)

    //Default binding _ with pattern guard – if none of the cases matches
   val msg1 = status match {
       case 500 => "Critical Error"
       case 200 => "Success"
       case x if (x ==300) => "Not found error"    //Pattern guard (don’t support else condition)
       case _ => "Unknown error"
        }

    println(msg1)



    // case expression for value extraction

    val nameAgeCity =Seq(("Pankaj", 29, "BLR"),
        ("Krishna", 45, "GWL") ,
        ("Sunil",23,"BIHAR"),
        ("Manoj" ,45,"GUJ"))

    //---calculate max age
     nameAgeCity.map(e=> e._2).reduce((m,n) => if (m > n) m else n)

    // calculate max age --other way
    nameAgeCity.map {
      case (name, age, city) => age
    }.reduce((m, n) => if (m > n) m else n)


   /* nameAgeCity.filter(
      e => e match {
        case(name,age,city) => age ==45
      }
    )*/

    // find the name and city where age == 45
    nameAgeCity.filter{
        case(name,age,city) => age ==45
    }.map{
      case(name,age,city) => (name,city)
    }


  }
}