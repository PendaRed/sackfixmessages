package org.sackfix.fix50sp2

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixComponent, SfFixDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20210314
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP2.xml
  */
case class StatsIndGrpComponent(noStatsIndicatorsField:Option[NoStatsIndicatorsField]=None,
                                statsIndicatorsGroups: Option[List[StatsIndicatorsGroup]]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {
  if (noStatsIndicatorsField.map(_.value).getOrElse(0) != statsIndicatorsGroups.map(_.size).getOrElse(0))
    throw SfRepeatingGroupCountException(NoStatsIndicatorsField.TagId,noStatsIndicatorsField.map(_.value).getOrElse(0), statsIndicatorsGroups.map(_.size).getOrElse(0))

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    noStatsIndicatorsField.foreach(fmt(b,_))
    statsIndicatorsGroups.getOrElse(List.empty).foreach(fmt(b,_))
    b
  }

}
     
object StatsIndGrpComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    StatsIndicatorsGroup.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    NoStatsIndicatorsField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    StatsIndicatorsGroup.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    StatsIndicatorsGroup.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int](
    NoStatsIndicatorsField.TagId)
  
      
  override def isFirstField(tagId:Int) : Boolean = StatsIndicatorsGroup.isFirstField(tagId) 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[StatsIndGrpComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(StatsIndGrpComponent(myFields.get(NoStatsIndicatorsField.TagId).flatMap(f=>NoStatsIndicatorsField.decode(f)),
        if (nextTagPosLookup.contains(NoStatsIndicatorsField.TagId)) StatsIndicatorsGroup.decode(flds, nextTagPosLookup(NoStatsIndicatorsField.TagId)) else None))
    } else None
  }

    
}
     