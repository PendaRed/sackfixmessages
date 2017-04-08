package org.sackfix.fix50sp2modified

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixComponent, SfFixDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20170404
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP2.modified.xml
  */
case class BidDescReqGrpComponent(noBidDescriptorsField:Option[NoBidDescriptorsField]=None,
                                  bidDescriptorsGroups: Option[List[BidDescriptorsGroup]]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noBidDescriptorsField.map(_.value).getOrElse(0) != bidDescriptorsGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoBidDescriptorsField.TagId,noBidDescriptorsField.map(_.value).getOrElse(0), bidDescriptorsGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    noBidDescriptorsField.foreach(fmt(b,_))
    bidDescriptorsGroups.getOrElse(List.empty).foreach(fmt(b,_))
    b
  }

}
     
object BidDescReqGrpComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    BidDescriptorsGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    NoBidDescriptorsField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    BidDescriptorsGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    BidDescriptorsGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoBidDescriptorsField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = BidDescriptorsGroup.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[BidDescReqGrpComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(BidDescReqGrpComponent(myFields.get(NoBidDescriptorsField.TagId).flatMap(f=>NoBidDescriptorsField.decode(f)),
        if (nextTagPosLookup.contains(NoBidDescriptorsField.TagId)) BidDescriptorsGroup.decode(flds, nextTagPosLookup(NoBidDescriptorsField.TagId)) else None))
    } else None
  }

    
}
     