package org.sackfix.fix50sp1modified

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixComponent, SfFixDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20170404
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP1.modified.xml
  */
case class DerivativeSecurityXMLComponent(derivativeSecurityXMLLenField:Option[DerivativeSecurityXMLLenField]=None,
                                          derivativeSecurityXMLDataField:Option[DerivativeSecurityXMLDataField]=None,
                                          derivativeSecurityXMLSchemaField:Option[DerivativeSecurityXMLSchemaField]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    derivativeSecurityXMLLenField.foreach(fmt(b,_))
    derivativeSecurityXMLDataField.foreach(fmt(b,_))
    derivativeSecurityXMLSchemaField.foreach(fmt(b,_))
    b
  }

}
     
object DerivativeSecurityXMLComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId) 
  }

  override val OptionalFields = HashSet[Int](
    DerivativeSecurityXMLLenField.TagId, DerivativeSecurityXMLDataField.TagId, DerivativeSecurityXMLSchemaField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId) 
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId) 

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==DerivativeSecurityXMLLenField.TagId 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[DerivativeSecurityXMLComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(DerivativeSecurityXMLComponent(myFields.get(DerivativeSecurityXMLLenField.TagId).flatMap(f=>DerivativeSecurityXMLLenField.decode(f)),
        myFields.get(DerivativeSecurityXMLDataField.TagId).flatMap(f=>DerivativeSecurityXMLDataField.decode(f)),
        myFields.get(DerivativeSecurityXMLSchemaField.TagId).flatMap(f=>DerivativeSecurityXMLSchemaField.decode(f))))
    } else None
  }

    
}
     