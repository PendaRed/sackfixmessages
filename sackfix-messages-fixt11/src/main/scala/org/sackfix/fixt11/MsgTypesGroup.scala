package org.sackfix.fixt11

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixGroup, SfGroupDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20210314
  * Source specification was read from:
  *   /quickfixj1.6.0/FIXT11.xml
  */
case class MsgTypesGroup(refMsgTypeField:Option[RefMsgTypeField]=None,
                         msgDirectionField:Option[MsgDirectionField]=None,
                         refApplVerIDField:Option[RefApplVerIDField]=None,
                         refApplExtIDField:Option[RefApplExtIDField]=None,
                         refCstmApplVerIDField:Option[RefCstmApplVerIDField]=None,
                         defaultVerIndicatorField:Option[DefaultVerIndicatorField]=None) extends SfFixGroup  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    refMsgTypeField.foreach(fmt(b,_))
    msgDirectionField.foreach(fmt(b,_))
    refApplVerIDField.foreach(fmt(b,_))
    refApplExtIDField.foreach(fmt(b,_))
    refCstmApplVerIDField.foreach(fmt(b,_))
    defaultVerIndicatorField.foreach(fmt(b,_))
    b
  }

}
     
object MsgTypesGroup extends SfGroupDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId) 
  }

  override val OptionalFields = HashSet[Int](
    RefMsgTypeField.TagId, MsgDirectionField.TagId, RefApplVerIDField.TagId, RefApplExtIDField.TagId, RefCstmApplVerIDField.TagId, 
    DefaultVerIndicatorField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId) 
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId) 

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==RefMsgTypeField.TagId 

  // Group version, startPos is the index to the first element of the first repeating group
  @tailrec
  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0, groups:ArrayBuffer[MsgTypesGroup]=ArrayBuffer.empty[MsgTypesGroup]):Option[List[MsgTypesGroup]] = {
    decodeSingle(flds, startPos) match {
      case (pos: Int, None) => if (groups.nonEmpty) Some(groups.toList) else None
      case (pos: Int, grp: Some[MsgTypesGroup]) => decode(flds, pos, groups += grp.get)
    }
  }

  /**
    * @param flds For groups in Fix ordering is VITAL.
    * @param startPos This index into the ordered fields. It HAS to contain the first field of the group
    * @return A Tuple2 holding the next position to read from the fields, and the newly created group
    */
  def decodeSingle(flds: Seq[Tuple2[Int, Any]], startPos:Int):Tuple2[Int,Option[MsgTypesGroup]] = {
    if (!isFirstField(flds(startPos)._1)) (startPos, None)
    else {
      val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(true, flds, startPos)
      validateMandatoryFieldsPresent(myFields)

      if (myFields.nonEmpty) {
        (pos,Some(MsgTypesGroup(myFields.get(RefMsgTypeField.TagId).flatMap(f=>RefMsgTypeField.decode(f)),
          myFields.get(MsgDirectionField.TagId).flatMap(f=>MsgDirectionField.decode(f)),
          myFields.get(RefApplVerIDField.TagId).flatMap(f=>RefApplVerIDField.decode(f)),
          myFields.get(RefApplExtIDField.TagId).flatMap(f=>RefApplExtIDField.decode(f)),
          myFields.get(RefCstmApplVerIDField.TagId).flatMap(f=>RefCstmApplVerIDField.decode(f)),
          myFields.get(DefaultVerIndicatorField.TagId).flatMap(f=>DefaultVerIndicatorField.decode(f)))))
      } else (startPos, None)
    }
  }
    
}
     