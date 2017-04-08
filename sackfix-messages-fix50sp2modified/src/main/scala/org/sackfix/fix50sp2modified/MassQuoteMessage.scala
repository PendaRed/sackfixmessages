package org.sackfix.fix50sp2modified

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20170404
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP2.modified.xml
  */
case class MassQuoteMessage(quoteReqIDField:Option[QuoteReqIDField]=None,
                            quoteIDField:QuoteIDField,
                            quoteTypeField:Option[QuoteTypeField]=None,
                            quoteResponseLevelField:Option[QuoteResponseLevelField]=None,
                            partiesComponent:Option[PartiesComponent]=None,
                            accountField:Option[AccountField]=None,
                            acctIDSourceField:Option[AcctIDSourceField]=None,
                            accountTypeField:Option[AccountTypeField]=None,
                            defBidSizeField:Option[DefBidSizeField]=None,
                            defOfferSizeField:Option[DefOfferSizeField]=None,
                            quotSetGrpComponent:QuotSetGrpComponent) extends SfFixMessageBody("i")  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    quoteReqIDField.foreach(fmt(b,_))
    fmt(b,quoteIDField)
    quoteTypeField.foreach(fmt(b,_))
    quoteResponseLevelField.foreach(fmt(b,_))
    partiesComponent.foreach(fmt(b,_))
    accountField.foreach(fmt(b,_))
    acctIDSourceField.foreach(fmt(b,_))
    accountTypeField.foreach(fmt(b,_))
    defBidSizeField.foreach(fmt(b,_))
    defOfferSizeField.foreach(fmt(b,_))
    fmt(b,quotSetGrpComponent)
    b
  }

}
     
object MassQuoteMessage extends SfFixMessageDecoder {
  val MsgType="i"
  val MsgName="MassQuote"
             
  override val MandatoryFields = HashSet[Int](
    QuoteIDField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    PartiesComponent.isMandatoryField(tagId) || QuotSetGrpComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    QuoteReqIDField.TagId, QuoteTypeField.TagId, QuoteResponseLevelField.TagId, AccountField.TagId, AcctIDSourceField.TagId, 
    AccountTypeField.TagId, DefBidSizeField.TagId, DefOfferSizeField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    PartiesComponent.isOptionalField(tagId) || QuotSetGrpComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    PartiesComponent.isFieldOf(tagId) || QuotSetGrpComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==QuoteReqIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(MassQuoteMessage(myFields.get(QuoteReqIDField.TagId).flatMap(f=>QuoteReqIDField.decode(f)),
        QuoteIDField.decode(myFields.get(QuoteIDField.TagId)).get,
        myFields.get(QuoteTypeField.TagId).flatMap(f=>QuoteTypeField.decode(f)),
        myFields.get(QuoteResponseLevelField.TagId).flatMap(f=>QuoteResponseLevelField.decode(f)),
        PartiesComponent.decode(flds, startPos),
        myFields.get(AccountField.TagId).flatMap(f=>AccountField.decode(f)),
        myFields.get(AcctIDSourceField.TagId).flatMap(f=>AcctIDSourceField.decode(f)),
        myFields.get(AccountTypeField.TagId).flatMap(f=>AccountTypeField.decode(f)),
        myFields.get(DefBidSizeField.TagId).flatMap(f=>DefBidSizeField.decode(f)),
        myFields.get(DefOfferSizeField.TagId).flatMap(f=>DefOfferSizeField.decode(f)),
        QuotSetGrpComponent.decode(flds, startPos).get))
    } else None
  }

    
}
     