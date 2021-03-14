package org.sackfix.fix50sp1modified

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20210314
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP1.modified.xml
  */
case class PositionMaintenanceRequestMessage(posReqIDField:Option[PosReqIDField]=None,
                                             posTransTypeField:PosTransTypeField,
                                             posMaintActionField:PosMaintActionField,
                                             origPosReqRefIDField:Option[OrigPosReqRefIDField]=None,
                                             posMaintRptRefIDField:Option[PosMaintRptRefIDField]=None,
                                             clearingBusinessDateField:ClearingBusinessDateField,
                                             settlSessIDField:Option[SettlSessIDField]=None,
                                             settlSessSubIDField:Option[SettlSessSubIDField]=None,
                                             partiesComponent:PartiesComponent,
                                             accountField:Option[AccountField]=None,
                                             acctIDSourceField:Option[AcctIDSourceField]=None,
                                             accountTypeField:Option[AccountTypeField]=None,
                                             instrumentComponent:InstrumentComponent,
                                             currencyField:Option[CurrencyField]=None,
                                             instrmtLegGrpComponent:Option[InstrmtLegGrpComponent]=None,
                                             undInstrmtGrpComponent:Option[UndInstrmtGrpComponent]=None,
                                             trdgSesGrpComponent:Option[TrdgSesGrpComponent]=None,
                                             transactTimeField:Option[TransactTimeField]=None,
                                             positionQtyComponent:PositionQtyComponent,
                                             positionAmountDataComponent:Option[PositionAmountDataComponent]=None,
                                             adjustmentTypeField:Option[AdjustmentTypeField]=None,
                                             contraryInstructionIndicatorField:Option[ContraryInstructionIndicatorField]=None,
                                             priorSpreadIndicatorField:Option[PriorSpreadIndicatorField]=None,
                                             thresholdAmountField:Option[ThresholdAmountField]=None,
                                             textField:Option[TextField]=None,
                                             encodedTextLenField:Option[EncodedTextLenField]=None,
                                             encodedTextField:Option[EncodedTextField]=None,
                                             settlCurrencyField:Option[SettlCurrencyField]=None) extends SfFixMessageBody("AL")  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    posReqIDField.foreach(fmt(b,_))
    fmt(b,posTransTypeField)
    fmt(b,posMaintActionField)
    origPosReqRefIDField.foreach(fmt(b,_))
    posMaintRptRefIDField.foreach(fmt(b,_))
    fmt(b,clearingBusinessDateField)
    settlSessIDField.foreach(fmt(b,_))
    settlSessSubIDField.foreach(fmt(b,_))
    fmt(b,partiesComponent)
    accountField.foreach(fmt(b,_))
    acctIDSourceField.foreach(fmt(b,_))
    accountTypeField.foreach(fmt(b,_))
    fmt(b,instrumentComponent)
    currencyField.foreach(fmt(b,_))
    instrmtLegGrpComponent.foreach(fmt(b,_))
    undInstrmtGrpComponent.foreach(fmt(b,_))
    trdgSesGrpComponent.foreach(fmt(b,_))
    transactTimeField.foreach(fmt(b,_))
    fmt(b,positionQtyComponent)
    positionAmountDataComponent.foreach(fmt(b,_))
    adjustmentTypeField.foreach(fmt(b,_))
    contraryInstructionIndicatorField.foreach(fmt(b,_))
    priorSpreadIndicatorField.foreach(fmt(b,_))
    thresholdAmountField.foreach(fmt(b,_))
    textField.foreach(fmt(b,_))
    encodedTextLenField.foreach(fmt(b,_))
    encodedTextField.foreach(fmt(b,_))
    settlCurrencyField.foreach(fmt(b,_))
    b
  }

}
     
object PositionMaintenanceRequestMessage extends SfFixMessageDecoder {
  val MsgType="AL"
  val MsgName="PositionMaintenanceRequest"
             
  override val MandatoryFields = HashSet[Int](
    PosTransTypeField.TagId, PosMaintActionField.TagId, ClearingBusinessDateField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    PartiesComponent.isMandatoryField(tagId) || InstrumentComponent.isMandatoryField(tagId) || InstrmtLegGrpComponent.isMandatoryField(tagId) || UndInstrmtGrpComponent.isMandatoryField(tagId) || 
    TrdgSesGrpComponent.isMandatoryField(tagId) || PositionQtyComponent.isMandatoryField(tagId) || PositionAmountDataComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    PosReqIDField.TagId, OrigPosReqRefIDField.TagId, PosMaintRptRefIDField.TagId, SettlSessIDField.TagId, SettlSessSubIDField.TagId, 
    AccountField.TagId, AcctIDSourceField.TagId, AccountTypeField.TagId, CurrencyField.TagId, TransactTimeField.TagId, 
    AdjustmentTypeField.TagId, ContraryInstructionIndicatorField.TagId, PriorSpreadIndicatorField.TagId, ThresholdAmountField.TagId, TextField.TagId, 
    EncodedTextLenField.TagId, EncodedTextField.TagId, SettlCurrencyField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    PartiesComponent.isOptionalField(tagId) || InstrumentComponent.isOptionalField(tagId) || InstrmtLegGrpComponent.isOptionalField(tagId) || UndInstrmtGrpComponent.isOptionalField(tagId) || 
    TrdgSesGrpComponent.isOptionalField(tagId) || PositionQtyComponent.isOptionalField(tagId) || PositionAmountDataComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    PartiesComponent.isFieldOf(tagId) || InstrumentComponent.isFieldOf(tagId) || InstrmtLegGrpComponent.isFieldOf(tagId) || 
    UndInstrmtGrpComponent.isFieldOf(tagId) || TrdgSesGrpComponent.isFieldOf(tagId) || PositionQtyComponent.isFieldOf(tagId) || 
    PositionAmountDataComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==PosReqIDField.TagId 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(PositionMaintenanceRequestMessage(myFields.get(PosReqIDField.TagId).flatMap(f=>PosReqIDField.decode(f)),
        PosTransTypeField.decode(myFields.get(PosTransTypeField.TagId)).get,
        PosMaintActionField.decode(myFields.get(PosMaintActionField.TagId)).get,
        myFields.get(OrigPosReqRefIDField.TagId).flatMap(f=>OrigPosReqRefIDField.decode(f)),
        myFields.get(PosMaintRptRefIDField.TagId).flatMap(f=>PosMaintRptRefIDField.decode(f)),
        ClearingBusinessDateField.decode(myFields.get(ClearingBusinessDateField.TagId)).get,
        myFields.get(SettlSessIDField.TagId).flatMap(f=>SettlSessIDField.decode(f)),
        myFields.get(SettlSessSubIDField.TagId).flatMap(f=>SettlSessSubIDField.decode(f)),
        PartiesComponent.decode(flds, startPos).get,
        myFields.get(AccountField.TagId).flatMap(f=>AccountField.decode(f)),
        myFields.get(AcctIDSourceField.TagId).flatMap(f=>AcctIDSourceField.decode(f)),
        myFields.get(AccountTypeField.TagId).flatMap(f=>AccountTypeField.decode(f)),
        InstrumentComponent.decode(flds, startPos).get,
        myFields.get(CurrencyField.TagId).flatMap(f=>CurrencyField.decode(f)),
        InstrmtLegGrpComponent.decode(flds, startPos),
        UndInstrmtGrpComponent.decode(flds, startPos),
        TrdgSesGrpComponent.decode(flds, startPos),
        myFields.get(TransactTimeField.TagId).flatMap(f=>TransactTimeField.decode(f)),
        PositionQtyComponent.decode(flds, startPos).get,
        PositionAmountDataComponent.decode(flds, startPos),
        myFields.get(AdjustmentTypeField.TagId).flatMap(f=>AdjustmentTypeField.decode(f)),
        myFields.get(ContraryInstructionIndicatorField.TagId).flatMap(f=>ContraryInstructionIndicatorField.decode(f)),
        myFields.get(PriorSpreadIndicatorField.TagId).flatMap(f=>PriorSpreadIndicatorField.decode(f)),
        myFields.get(ThresholdAmountField.TagId).flatMap(f=>ThresholdAmountField.decode(f)),
        myFields.get(TextField.TagId).flatMap(f=>TextField.decode(f)),
        myFields.get(EncodedTextLenField.TagId).flatMap(f=>EncodedTextLenField.decode(f)),
        myFields.get(EncodedTextField.TagId).flatMap(f=>EncodedTextField.decode(f)),
        myFields.get(SettlCurrencyField.TagId).flatMap(f=>SettlCurrencyField.decode(f))))
    } else None
  }

    
}
     