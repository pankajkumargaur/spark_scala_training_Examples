package scala_concepts_examples

import scala.io.Source
import scala.util.{Failure, Success, Try}

/**
  * Created by Pankaj Gaur on 08-06-2019.
  */



// monads for error handeling

object Problem3_Scala_Refresher {
  def main(args: Array[String]) {

    // TRys and sucess failure
    val filename = "src\\main\\Input\\emp_data.txt"
    readTextFile(filename) match {
      case Success(lines) => lines.foreach(println)
      case Failure(f) => println("my object :::: " + f)
    }

    // OPTIONS and SOME and NONE
    val capitals = Map("France" -> "Paris", "Japan" -> "Tokyo")

    println("capitals.get( \"France\" ) : " +  capitals.get( "France" ))
    println("capitals.get( \"India\" ) : " +  capitals.get( "India" ))


    println("show(capitals.get( \"Japan\")) : " + show(capitals.get( "Japan")) )
    println("show(capitals.get( \"India\")) : " + show(capitals.get( "India")) )

    capitals.get("Japan") match {
      case Some(str) => println(s"found $str")
      case None=> println("Nothing found")
    }

    toInt("s12") match {
      case Some(i) => println(i)
      case None => println("That didn't work.")
    }

    // LEFT and Right

    val in = Console.readLine("Type Either a string or an Int: ")

    val result: Either[String,Int] =
      try {
        Right(in.toInt)
      }
      catch {
      case e: Exception =>
        Left(in)
    }

    println( result match {
      case Right(x) => "You passed me the Int: " + x + ", which I will increment. " + x + " + 1 = " + (x+1)
      case Left(x) => "You passed me the String: " + x
    })


  }

  def readTextFile(filename: String): Try[List[String]] =
  {
    Try(Source.fromFile(filename).getLines.toList)
  }

  def show(x: Option[String]) = x match {
    case Some(s) => s
    case None => "?"
  }

  def toInt(in: String): Option[Int] = {
    try {
      Some(Integer.parseInt(in.trim))
    } catch {
      case e: NumberFormatException => None
    }
  }






}