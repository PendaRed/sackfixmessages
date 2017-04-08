package org.sackfix.fix50sp1modified

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixMessageBody, SfFixMessageDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20170404
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP1.modified.xml
  */
case class NewsMessage(applicationSequenceControlComponent:Option[ApplicationSequenceControlComponent]=None,
                       origTimeField:Option[OrigTimeField]=None,
                       urgencyField:Option[UrgencyField]=None,
                       headlineField:HeadlineField,
                       encodedHeadlineLenField:Option[EncodedHeadlineLenField]=None,
                       encodedHeadlineField:Option[EncodedHeadlineField]=None,
                       routingGrpComponent:Option[RoutingGrpComponent]=None,
                       instrmtGrpComponent:Option[InstrmtGrpComponent]=None,
                       instrmtLegGrpComponent:Option[InstrmtLegGrpComponent]=None,
                       undInstrmtGrpComponent:Option[UndInstrmtGrpComponent]=None,
                       linesOfTextGrpComponent:LinesOfTextGrpComponent,
                       uRLLinkField:Option[URLLinkField]=None,
                       rawDataLengthField:Option[RawDataLengthField]=None,
                       rawDataField:Option[RawDataField]=None) extends SfFixMessageBody("B")  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    applicationSequenceControlComponent.foreach(fmt(b,_))
    origTimeField.foreach(fmt(b,_))
    urgencyField.foreach(fmt(b,_))
    fmt(b,headlineField)
    encodedHeadlineLenField.foreach(fmt(b,_))
    encodedHeadlineField.foreach(fmt(b,_))
    routingGrpComponent.foreach(fmt(b,_))
    instrmtGrpComponent.foreach(fmt(b,_))
    instrmtLegGrpComponent.foreach(fmt(b,_))
    undInstrmtGrpComponent.foreach(fmt(b,_))
    fmt(b,linesOfTextGrpComponent)
    uRLLinkField.foreach(fmt(b,_))
    rawDataLengthField.foreach(fmt(b,_))
    rawDataField.foreach(fmt(b,_))
    b
  }

}
     
object NewsMessage extends SfFixMessageDecoder {
  val MsgType="B"
  val MsgName="News"
             
  override val MandatoryFields = HashSet[Int](
    HeadlineField.TagId)

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    ApplicationSequenceControlComponent.isMandatoryField(tagId) || RoutingGrpComponent.isMandatoryField(tagId) || InstrmtGrpComponent.isMandatoryField(tagId) || InstrmtLegGrpComponent.isMandatoryField(tagId) || 
    UndInstrmtGrpComponent.isMandatoryField(tagId) || LinesOfTextGrpComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    OrigTimeField.TagId, UrgencyField.TagId, EncodedHeadlineLenField.TagId, EncodedHeadlineField.TagId, URLLinkField.TagId, 
    RawDataLengthField.TagId, RawDataField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    ApplicationSequenceControlComponent.isOptionalField(tagId) || RoutingGrpComponent.isOptionalField(tagId) || InstrmtGrpComponent.isOptionalField(tagId) || InstrmtLegGrpComponent.isOptionalField(tagId) || 
    UndInstrmtGrpComponent.isOptionalField(tagId) || LinesOfTextGrpComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    ApplicationSequenceControlComponent.isFieldOf(tagId) || RoutingGrpComponent.isFieldOf(tagId) || InstrmtGrpComponent.isFieldOf(tagId) || 
    InstrmtLegGrpComponent.isFieldOf(tagId) || UndInstrmtGrpComponent.isFieldOf(tagId) || LinesOfTextGrpComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = ApplicationSequenceControlComponent.isFirstField(tagId) 

  override def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0):Option[SfFixMessageBody] = {
    val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(false, flds, startPos)
    validateMandatoryFieldsPresent(myFields)

    if (MandatoryFields.isEmpty || myFields.nonEmpty) {
      Some(NewsMessage(ApplicationSequenceControlComponent.decode(flds, startPos),
        myFields.get(OrigTimeField.TagId).flatMap(f=>OrigTimeField.decode(f)),
        myFields.get(UrgencyField.TagId).flatMap(f=>UrgencyField.decode(f)),
        HeadlineField.decode(myFields.get(HeadlineField.TagId)).get,
        myFields.get(EncodedHeadlineLenField.TagId).flatMap(f=>EncodedHeadlineLenField.decode(f)),
        myFields.get(EncodedHeadlineField.TagId).flatMap(f=>EncodedHeadlineField.decode(f)),
        RoutingGrpComponent.decode(flds, startPos),
        InstrmtGrpComponent.decode(flds, startPos),
        InstrmtLegGrpComponent.decode(flds, startPos),
        UndInstrmtGrpComponent.decode(flds, startPos),
        LinesOfTextGrpComponent.decode(flds, startPos).get,
        myFields.get(URLLinkField.TagId).flatMap(f=>URLLinkField.decode(f)),
        myFields.get(RawDataLengthField.TagId).flatMap(f=>RawDataLengthField.decode(f)),
        myFields.get(RawDataField.TagId).flatMap(f=>RawDataField.decode(f))))
    } else None
  }

    
}
     