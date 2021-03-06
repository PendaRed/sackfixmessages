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
case class OrdAllocGrpComponent(noOrdersField:Option[NoOrdersField]=None,
                                ordersGroups: Option[List[OrdersGroup]]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noOrdersField.map(_.value).getOrElse(0) != ordersGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoOrdersField.TagId,noOrdersField.map(_.value).getOrElse(0), ordersGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    noOrdersField.foreach(fmt(b,_))
    ordersGroups.getOrElse(List.empty).foreach(fmt(b,_))
    b
  }

}
     
object OrdAllocGrpComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    OrdersGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    NoOrdersField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    OrdersGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    OrdersGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoOrdersField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = OrdersGroup.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[OrdAllocGrpComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(OrdAllocGrpComponent(myFields.get(NoOrdersField.TagId).flatMap(f=>NoOrdersField.decode(f)),
        if (nextTagPosLookup.contains(NoOrdersField.TagId)) OrdersGroup.decode(flds, nextTagPosLookup(NoOrdersField.TagId)) else None))
    } else None
  }

    
}
     