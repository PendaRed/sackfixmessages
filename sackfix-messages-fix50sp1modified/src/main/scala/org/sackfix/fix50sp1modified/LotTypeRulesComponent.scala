package org.sackfix.fix50sp1modified

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixComponent, SfFixDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20210314
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP1.modified.xml
  */
case class LotTypeRulesComponent(noLotTypeRulesField:Option[NoLotTypeRulesField]=None,
                                 lotTypeRulesGroups: Option[List[LotTypeRulesGroup]]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noLotTypeRulesField.map(_.value).getOrElse(0) != lotTypeRulesGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoLotTypeRulesField.TagId,noLotTypeRulesField.map(_.value).getOrElse(0), lotTypeRulesGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    noLotTypeRulesField.foreach(fmt(b,_))
    lotTypeRulesGroups.getOrElse(List.empty).foreach(fmt(b,_))
    b
  }

}
     
object LotTypeRulesComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    LotTypeRulesGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    NoLotTypeRulesField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    LotTypeRulesGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    LotTypeRulesGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoLotTypeRulesField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = LotTypeRulesGroup.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[LotTypeRulesComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(LotTypeRulesComponent(myFields.get(NoLotTypeRulesField.TagId).flatMap(f=>NoLotTypeRulesField.decode(f)),
        if (nextTagPosLookup.contains(NoLotTypeRulesField.TagId)) LotTypeRulesGroup.decode(flds, nextTagPosLookup(NoLotTypeRulesField.TagId)) else None))
    } else None
  }

    
}
     