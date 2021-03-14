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
case class ApplicationSequenceControlComponent(applIDField:Option[ApplIDField]=None,
                                               applSeqNumField:Option[ApplSeqNumField]=None,
                                               applLastSeqNumField:Option[ApplLastSeqNumField]=None,
                                               applResendFlagField:Option[ApplResendFlagField]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    applIDField.foreach(fmt(b,_))
    applSeqNumField.foreach(fmt(b,_))
    applLastSeqNumField.foreach(fmt(b,_))
    applResendFlagField.foreach(fmt(b,_))
    b
  }

}
     
object ApplicationSequenceControlComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId) 
  }

  override val OptionalFields = HashSet[Int](
    ApplIDField.TagId, ApplSeqNumField.TagId, ApplLastSeqNumField.TagId, ApplResendFlagField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId) 
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId) 

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==ApplIDField.TagId 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[ApplicationSequenceControlComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(ApplicationSequenceControlComponent(myFields.get(ApplIDField.TagId).flatMap(f=>ApplIDField.decode(f)),
        myFields.get(ApplSeqNumField.TagId).flatMap(f=>ApplSeqNumField.decode(f)),
        myFields.get(ApplLastSeqNumField.TagId).flatMap(f=>ApplLastSeqNumField.decode(f)),
        myFields.get(ApplResendFlagField.TagId).flatMap(f=>ApplResendFlagField.decode(f))))
    } else None
  }

    
}
     