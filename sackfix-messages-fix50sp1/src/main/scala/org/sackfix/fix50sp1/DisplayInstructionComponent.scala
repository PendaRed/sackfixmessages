package org.sackfix.fix50sp1

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixComponent, SfFixDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20210314
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP1.xml
  */
case class DisplayInstructionComponent(displayQtyField:Option[DisplayQtyField]=None,
                                       secondaryDisplayQtyField:Option[SecondaryDisplayQtyField]=None,
                                       displayWhenField:Option[DisplayWhenField]=None,
                                       displayMethodField:Option[DisplayMethodField]=None,
                                       displayLowQtyField:Option[DisplayLowQtyField]=None,
                                       displayHighQtyField:Option[DisplayHighQtyField]=None,
                                       displayMinIncrField:Option[DisplayMinIncrField]=None,
                                       refreshQtyField:Option[RefreshQtyField]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    displayQtyField.foreach(fmt(b,_))
    secondaryDisplayQtyField.foreach(fmt(b,_))
    displayWhenField.foreach(fmt(b,_))
    displayMethodField.foreach(fmt(b,_))
    displayLowQtyField.foreach(fmt(b,_))
    displayHighQtyField.foreach(fmt(b,_))
    displayMinIncrField.foreach(fmt(b,_))
    refreshQtyField.foreach(fmt(b,_))
    b
  }

}
     
object DisplayInstructionComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId) 
  }

  override val OptionalFields = HashSet[Int](
    DisplayQtyField.TagId, SecondaryDisplayQtyField.TagId, DisplayWhenField.TagId, DisplayMethodField.TagId, DisplayLowQtyField.TagId, 
    DisplayHighQtyField.TagId, DisplayMinIncrField.TagId, RefreshQtyField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId) 
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId) 

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==DisplayQtyField.TagId 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[DisplayInstructionComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(DisplayInstructionComponent(myFields.get(DisplayQtyField.TagId).flatMap(f=>DisplayQtyField.decode(f)),
        myFields.get(SecondaryDisplayQtyField.TagId).flatMap(f=>SecondaryDisplayQtyField.decode(f)),
        myFields.get(DisplayWhenField.TagId).flatMap(f=>DisplayWhenField.decode(f)),
        myFields.get(DisplayMethodField.TagId).flatMap(f=>DisplayMethodField.decode(f)),
        myFields.get(DisplayLowQtyField.TagId).flatMap(f=>DisplayLowQtyField.decode(f)),
        myFields.get(DisplayHighQtyField.TagId).flatMap(f=>DisplayHighQtyField.decode(f)),
        myFields.get(DisplayMinIncrField.TagId).flatMap(f=>DisplayMinIncrField.decode(f)),
        myFields.get(RefreshQtyField.TagId).flatMap(f=>RefreshQtyField.decode(f))))
    } else None
  }

    
}
     