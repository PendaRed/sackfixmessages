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
case class UnderlyingLegInstrumentComponent(underlyingLegSymbolField:Option[UnderlyingLegSymbolField]=None,
                                            underlyingLegSymbolSfxField:Option[UnderlyingLegSymbolSfxField]=None,
                                            underlyingLegSecurityIDField:Option[UnderlyingLegSecurityIDField]=None,
                                            underlyingLegSecurityIDSourceField:Option[UnderlyingLegSecurityIDSourceField]=None,
                                            underlyingLegSecurityAltIDGrpComponent:Option[UnderlyingLegSecurityAltIDGrpComponent]=None,
                                            underlyingLegCFICodeField:Option[UnderlyingLegCFICodeField]=None,
                                            underlyingLegSecurityTypeField:Option[UnderlyingLegSecurityTypeField]=None,
                                            underlyingLegSecuritySubTypeField:Option[UnderlyingLegSecuritySubTypeField]=None,
                                            underlyingLegMaturityMonthYearField:Option[UnderlyingLegMaturityMonthYearField]=None,
                                            underlyingLegMaturityDateField:Option[UnderlyingLegMaturityDateField]=None,
                                            underlyingLegMaturityTimeField:Option[UnderlyingLegMaturityTimeField]=None,
                                            underlyingLegStrikePriceField:Option[UnderlyingLegStrikePriceField]=None,
                                            underlyingLegOptAttributeField:Option[UnderlyingLegOptAttributeField]=None,
                                            underlyingLegPutOrCallField:Option[UnderlyingLegPutOrCallField]=None,
                                            underlyingLegSecurityExchangeField:Option[UnderlyingLegSecurityExchangeField]=None,
                                            underlyingLegSecurityDescField:Option[UnderlyingLegSecurityDescField]=None) extends SfFixComponent  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    underlyingLegSymbolField.foreach(fmt(b,_))
    underlyingLegSymbolSfxField.foreach(fmt(b,_))
    underlyingLegSecurityIDField.foreach(fmt(b,_))
    underlyingLegSecurityIDSourceField.foreach(fmt(b,_))
    underlyingLegSecurityAltIDGrpComponent.foreach(fmt(b,_))
    underlyingLegCFICodeField.foreach(fmt(b,_))
    underlyingLegSecurityTypeField.foreach(fmt(b,_))
    underlyingLegSecuritySubTypeField.foreach(fmt(b,_))
    underlyingLegMaturityMonthYearField.foreach(fmt(b,_))
    underlyingLegMaturityDateField.foreach(fmt(b,_))
    underlyingLegMaturityTimeField.foreach(fmt(b,_))
    underlyingLegStrikePriceField.foreach(fmt(b,_))
    underlyingLegOptAttributeField.foreach(fmt(b,_))
    underlyingLegPutOrCallField.foreach(fmt(b,_))
    underlyingLegSecurityExchangeField.foreach(fmt(b,_))
    underlyingLegSecurityDescField.foreach(fmt(b,_))
    b
  }

}
     
object UnderlyingLegInstrumentComponent extends SfFixDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    UnderlyingLegSecurityAltIDGrpComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    UnderlyingLegSymbolField.TagId, UnderlyingLegSymbolSfxField.TagId, UnderlyingLegSecurityIDField.TagId, UnderlyingLegSecurityIDSourceField.TagId, UnderlyingLegCFICodeField.TagId, 
    UnderlyingLegSecurityTypeField.TagId, UnderlyingLegSecuritySubTypeField.TagId, UnderlyingLegMaturityMonthYearField.TagId, UnderlyingLegMaturityDateField.TagId, UnderlyingLegMaturityTimeField.TagId, 
    UnderlyingLegStrikePriceField.TagId, UnderlyingLegOptAttributeField.TagId, UnderlyingLegPutOrCallField.TagId, UnderlyingLegSecurityExchangeField.TagId, UnderlyingLegSecurityDescField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    UnderlyingLegSecurityAltIDGrpComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    UnderlyingLegSecurityAltIDGrpComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==UnderlyingLegSymbolField.TagId 

  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[UnderlyingLegInstrumentComponent] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (myFields.nonEmpty) {
      Some(UnderlyingLegInstrumentComponent(myFields.get(UnderlyingLegSymbolField.TagId).flatMap(f=>UnderlyingLegSymbolField.decode(f)),
        myFields.get(UnderlyingLegSymbolSfxField.TagId).flatMap(f=>UnderlyingLegSymbolSfxField.decode(f)),
        myFields.get(UnderlyingLegSecurityIDField.TagId).flatMap(f=>UnderlyingLegSecurityIDField.decode(f)),
        myFields.get(UnderlyingLegSecurityIDSourceField.TagId).flatMap(f=>UnderlyingLegSecurityIDSourceField.decode(f)),
        UnderlyingLegSecurityAltIDGrpComponent.decode(flds, startPos),
        myFields.get(UnderlyingLegCFICodeField.TagId).flatMap(f=>UnderlyingLegCFICodeField.decode(f)),
        myFields.get(UnderlyingLegSecurityTypeField.TagId).flatMap(f=>UnderlyingLegSecurityTypeField.decode(f)),
        myFields.get(UnderlyingLegSecuritySubTypeField.TagId).flatMap(f=>UnderlyingLegSecuritySubTypeField.decode(f)),
        myFields.get(UnderlyingLegMaturityMonthYearField.TagId).flatMap(f=>UnderlyingLegMaturityMonthYearField.decode(f)),
        myFields.get(UnderlyingLegMaturityDateField.TagId).flatMap(f=>UnderlyingLegMaturityDateField.decode(f)),
        myFields.get(UnderlyingLegMaturityTimeField.TagId).flatMap(f=>UnderlyingLegMaturityTimeField.decode(f)),
        myFields.get(UnderlyingLegStrikePriceField.TagId).flatMap(f=>UnderlyingLegStrikePriceField.decode(f)),
        myFields.get(UnderlyingLegOptAttributeField.TagId).flatMap(f=>UnderlyingLegOptAttributeField.decode(f)),
        myFields.get(UnderlyingLegPutOrCallField.TagId).flatMap(f=>UnderlyingLegPutOrCallField.decode(f)),
        myFields.get(UnderlyingLegSecurityExchangeField.TagId).flatMap(f=>UnderlyingLegSecurityExchangeField.decode(f)),
        myFields.get(UnderlyingLegSecurityDescField.TagId).flatMap(f=>UnderlyingLegSecurityDescField.decode(f))))
    } else None
  }

    
}
     