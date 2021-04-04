package org.sackfix.fix50

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20210314
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50.xml
  */
case class QuoteCancelMessage(quoteReqIDField:Option[QuoteReqIDField]=None,
                              quoteIDField:Option[QuoteIDField]=None,
                              quoteCancelTypeField:QuoteCancelTypeField,
                              quoteResponseLevelField:Option[QuoteResponseLevelField]=None,
                              partiesComponent:Option[PartiesComponent]=None,
                              accountField:Option[AccountField]=None,
                              acctIDSourceField:Option[AcctIDSourceField]=None,
                              accountTypeField:Option[AccountTypeField]=None,
                              tradingSessionIDField:Option[TradingSessionIDField]=None,
                              tradingSessionSubIDField:Option[TradingSessionSubIDField]=None,
                              quotCxlEntriesGrpComponent:Option[QuotCxlEntriesGrpComponent]=None) extends SfFixMessageBody("Z")  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    quoteReqIDField.foreach(fmt(b,_))
    quoteIDField.foreach(fmt(b,_))
    fmt(b,quoteCancelTypeField)
    quoteResponseLevelField.foreach(fmt(b,_))
    partiesComponent.foreach(fmt(b,_))
    accountField.foreach(fmt(b,_))
    acctIDSourceField.foreach(fmt(b,_))
    accountTypeField.foreach(fmt(b,_))
    tradingSessionIDField.foreach(fmt(b,_))
    tradingSessionSubIDField.foreach(fmt(b,_))
    quotCxlEntriesGrpComponent.foreach(fmt(b,_))
    b
  }

}
     
object QuoteCancelMessage extends SfFixMessageDecoder {
  val MsgType="Z"
  val MsgName="QuoteCancel"
             
  override val MandatoryFields = HashSet[Int](
    QuoteCancelTypeField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    PartiesComponent.isMandatoryField(tagId) || QuotCxlEntriesGrpComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    QuoteReqIDField.TagId, QuoteIDField.TagId, QuoteResponseLevelField.TagId, AccountField.TagId, AcctIDSourceField.TagId, 
    AccountTypeField.TagId, TradingSessionIDField.TagId, TradingSessionSubIDField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    PartiesComponent.isOptionalField(tagId) || QuotCxlEntriesGrpComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    PartiesComponent.isFieldOf(tagId) || QuotCxlEntriesGrpComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==QuoteReqIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(QuoteCancelMessage(myFields.get(QuoteReqIDField.TagId).flatMap(f=>QuoteReqIDField.decode(f)),
        myFields.get(QuoteIDField.TagId).flatMap(f=>QuoteIDField.decode(f)),
        QuoteCancelTypeField.decode(myFields.get(QuoteCancelTypeField.TagId)).get,
        myFields.get(QuoteResponseLevelField.TagId).flatMap(f=>QuoteResponseLevelField.decode(f)),
        PartiesComponent.decode(flds, startPos),
        myFields.get(AccountField.TagId).flatMap(f=>AccountField.decode(f)),
        myFields.get(AcctIDSourceField.TagId).flatMap(f=>AcctIDSourceField.decode(f)),
        myFields.get(AccountTypeField.TagId).flatMap(f=>AccountTypeField.decode(f)),
        myFields.get(TradingSessionIDField.TagId).flatMap(f=>TradingSessionIDField.decode(f)),
        myFields.get(TradingSessionSubIDField.TagId).flatMap(f=>TradingSessionSubIDField.decode(f)),
        QuotCxlEntriesGrpComponent.decode(flds, startPos)))
    } else None
  }

    
}
     