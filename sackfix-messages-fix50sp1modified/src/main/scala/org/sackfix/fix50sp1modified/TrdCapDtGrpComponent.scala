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
case class TrdCapDtGrpComponent(noDatesField:Option[NoDatesField]=None,
                                datesGroups: Option[List[DatesGroup]]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noDatesField.map(_.value).getOrElse(0) != datesGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoDatesField.TagId,noDatesField.map(_.value).getOrElse(0), datesGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    noDatesField.foreach(fmt(b,_))
    datesGroups.getOrElse(List.empty).foreach(fmt(b,_))
    b
  }

}
     
object TrdCapDtGrpComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    DatesGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    NoDatesField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    DatesGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    DatesGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoDatesField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = DatesGroup.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[TrdCapDtGrpComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(TrdCapDtGrpComponent(myFields.get(NoDatesField.TagId).flatMap(f=>NoDatesField.decode(f)),
        if (nextTagPosLookup.contains(NoDatesField.TagId)) DatesGroup.decode(flds, nextTagPosLookup(NoDatesField.TagId)) else None))
    } else None
  }

    
}
     