package org.sackfix.fix50

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixGroup, SfGroupDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20210314
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50.xml
  */
case class BidComponentsGroup(commissionDataComponent:Option[CommissionDataComponent]=None,
                              listIDField:Option[ListIDField]=None,
                              countryField:Option[CountryField]=None,
                              sideField:Option[SideField]=None,
                              priceField:Option[PriceField]=None,
                              priceTypeField:Option[PriceTypeField]=None,
                              fairValueField:Option[FairValueField]=None,
                              netGrossIndField:Option[NetGrossIndField]=None,
                              settlTypeField:Option[SettlTypeField]=None,
                              settlDateField:Option[SettlDateField]=None,
                              tradingSessionIDField:Option[TradingSessionIDField]=None,
                              tradingSessionSubIDField:Option[TradingSessionSubIDField]=None,
                              textField:Option[TextField]=None,
                              encodedTextLenField:Option[EncodedTextLenField]=None,
                              encodedTextField:Option[EncodedTextField]=None) extends SfFixGroup  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    commissionDataComponent.foreach(fmt(b,_))
    listIDField.foreach(fmt(b,_))
    countryField.foreach(fmt(b,_))
    sideField.foreach(fmt(b,_))
    priceField.foreach(fmt(b,_))
    priceTypeField.foreach(fmt(b,_))
    fairValueField.foreach(fmt(b,_))
    netGrossIndField.foreach(fmt(b,_))
    settlTypeField.foreach(fmt(b,_))
    settlDateField.foreach(fmt(b,_))
    tradingSessionIDField.foreach(fmt(b,_))
    tradingSessionSubIDField.foreach(fmt(b,_))
    textField.foreach(fmt(b,_))
    encodedTextLenField.foreach(fmt(b,_))
    encodedTextField.foreach(fmt(b,_))
    b
  }

}
     
object BidComponentsGroup extends SfGroupDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    CommissionDataComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    ListIDField.TagId, CountryField.TagId, SideField.TagId, PriceField.TagId, PriceTypeField.TagId, 
    FairValueField.TagId, NetGrossIndField.TagId, SettlTypeField.TagId, SettlDateField.TagId, TradingSessionIDField.TagId, 
    TradingSessionSubIDField.TagId, TextField.TagId, EncodedTextLenField.TagId, EncodedTextField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    CommissionDataComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    CommissionDataComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = CommissionDataComponent.isFirstField(tagId) 

  // Group version, startPos is the index to the first element of the first repeating group
  @tailrec
  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0, groups:ArrayBuffer[BidComponentsGroup]=ArrayBuffer.empty[BidComponentsGroup]):Option[List[BidComponentsGroup]] = {
    decodeSingle(flds, startPos) match {
      case (pos: Int, None) => if (groups.nonEmpty) Some(groups.toList) else None
      case (pos: Int, grp: Some[BidComponentsGroup]) => decode(flds, pos, groups += grp.get)
    }
  }

  /**
    * @param flds For groups in Fix ordering is VITAL.
    * @param startPos This index into the ordered fields. It HAS to contain the first field of the group
    * @return A Tuple2 holding the next position to read from the fields, and the newly created group
    */
  def decodeSingle(flds: Seq[Tuple2[Int, Any]], startPos:Int):Tuple2[Int,Option[BidComponentsGroup]] = {
    if (!isFirstField(flds(startPos)._1)) (startPos, None)
    else {
      val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(true, flds, startPos)
      validateMandatoryFieldsPresent(myFields)

      if (myFields.nonEmpty) {
        (pos,Some(BidComponentsGroup(CommissionDataComponent.decode(flds, startPos),
          myFields.get(ListIDField.TagId).flatMap(f=>ListIDField.decode(f)),
          myFields.get(CountryField.TagId).flatMap(f=>CountryField.decode(f)),
          myFields.get(SideField.TagId).flatMap(f=>SideField.decode(f)),
          myFields.get(PriceField.TagId).flatMap(f=>PriceField.decode(f)),
          myFields.get(PriceTypeField.TagId).flatMap(f=>PriceTypeField.decode(f)),
          myFields.get(FairValueField.TagId).flatMap(f=>FairValueField.decode(f)),
          myFields.get(NetGrossIndField.TagId).flatMap(f=>NetGrossIndField.decode(f)),
          myFields.get(SettlTypeField.TagId).flatMap(f=>SettlTypeField.decode(f)),
          myFields.get(SettlDateField.TagId).flatMap(f=>SettlDateField.decode(f)),
          myFields.get(TradingSessionIDField.TagId).flatMap(f=>TradingSessionIDField.decode(f)),
          myFields.get(TradingSessionSubIDField.TagId).flatMap(f=>TradingSessionSubIDField.decode(f)),
          myFields.get(TextField.TagId).flatMap(f=>TextField.decode(f)),
          myFields.get(EncodedTextLenField.TagId).flatMap(f=>EncodedTextLenField.decode(f)),
          myFields.get(EncodedTextField.TagId).flatMap(f=>EncodedTextField.decode(f)))))
      } else (startPos, None)
    }
  }
    
}
     