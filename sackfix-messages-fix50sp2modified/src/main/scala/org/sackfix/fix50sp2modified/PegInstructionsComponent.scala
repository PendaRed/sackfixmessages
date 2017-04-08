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
case class PegInstructionsComponent(pegOffsetValueField:Option[PegOffsetValueField]=None,
                                    pegPriceTypeField:Option[PegPriceTypeField]=None,
                                    pegMoveTypeField:Option[PegMoveTypeField]=None,
                                    pegOffsetTypeField:Option[PegOffsetTypeField]=None,
                                    pegLimitTypeField:Option[PegLimitTypeField]=None,
                                    pegRoundDirectionField:Option[PegRoundDirectionField]=None,
                                    pegScopeField:Option[PegScopeField]=None,
                                    pegSecurityIDSourceField:Option[PegSecurityIDSourceField]=None,
                                    pegSecurityIDField:Option[PegSecurityIDField]=None,
                                    pegSymbolField:Option[PegSymbolField]=None,
                                    pegSecurityDescField:Option[PegSecurityDescField]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    pegOffsetValueField.foreach(fmt(b,_))
    pegPriceTypeField.foreach(fmt(b,_))
    pegMoveTypeField.foreach(fmt(b,_))
    pegOffsetTypeField.foreach(fmt(b,_))
    pegLimitTypeField.foreach(fmt(b,_))
    pegRoundDirectionField.foreach(fmt(b,_))
    pegScopeField.foreach(fmt(b,_))
    pegSecurityIDSourceField.foreach(fmt(b,_))
    pegSecurityIDField.foreach(fmt(b,_))
    pegSymbolField.foreach(fmt(b,_))
    pegSecurityDescField.foreach(fmt(b,_))
    b
  }

}
     
object PegInstructionsComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId) 
  }

  override val OptionalFields = HashSet[Int](
    PegOffsetValueField.TagId, PegPriceTypeField.TagId, PegMoveTypeField.TagId, PegOffsetTypeField.TagId, PegLimitTypeField.TagId, 
    PegRoundDirectionField.TagId, PegScopeField.TagId, PegSecurityIDSourceField.TagId, PegSecurityIDField.TagId, PegSymbolField.TagId, 
    PegSecurityDescField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId) 
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId) 

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==PegOffsetValueField.TagId 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[PegInstructionsComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(PegInstructionsComponent(myFields.get(PegOffsetValueField.TagId).flatMap(f=>PegOffsetValueField.decode(f)),
        myFields.get(PegPriceTypeField.TagId).flatMap(f=>PegPriceTypeField.decode(f)),
        myFields.get(PegMoveTypeField.TagId).flatMap(f=>PegMoveTypeField.decode(f)),
        myFields.get(PegOffsetTypeField.TagId).flatMap(f=>PegOffsetTypeField.decode(f)),
        myFields.get(PegLimitTypeField.TagId).flatMap(f=>PegLimitTypeField.decode(f)),
        myFields.get(PegRoundDirectionField.TagId).flatMap(f=>PegRoundDirectionField.decode(f)),
        myFields.get(PegScopeField.TagId).flatMap(f=>PegScopeField.decode(f)),
        myFields.get(PegSecurityIDSourceField.TagId).flatMap(f=>PegSecurityIDSourceField.decode(f)),
        myFields.get(PegSecurityIDField.TagId).flatMap(f=>PegSecurityIDField.decode(f)),
        myFields.get(PegSymbolField.TagId).flatMap(f=>PegSymbolField.decode(f)),
        myFields.get(PegSecurityDescField.TagId).flatMap(f=>PegSecurityDescField.decode(f))))
    } else None
  }

    
}
     