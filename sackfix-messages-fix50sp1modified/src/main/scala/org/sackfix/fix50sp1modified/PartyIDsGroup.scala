package org.sackfix.fix50sp1modified

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixGroup, SfGroupDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20210314
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP1.modified.xml
  */
case class PartyIDsGroup(partyIDField:Option[PartyIDField]=None,
                         partyIDSourceField:Option[PartyIDSourceField]=None,
                         partyRoleField:Option[PartyRoleField]=None,
                         ptysSubGrpComponent:Option[PtysSubGrpComponent]=None) extends SfFixGroup  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    partyIDField.foreach(fmt(b,_))
    partyIDSourceField.foreach(fmt(b,_))
    partyRoleField.foreach(fmt(b,_))
    ptysSubGrpComponent.foreach(fmt(b,_))
    b
  }

}
     
object PartyIDsGroup extends SfGroupDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    PtysSubGrpComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    PartyIDField.TagId, PartyIDSourceField.TagId, PartyRoleField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    PtysSubGrpComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    PtysSubGrpComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==PartyIDField.TagId 

  // Group version, startPos is the index to the first element of the first repeating group
  @tailrec
  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0, groups:ArrayBuffer[PartyIDsGroup]=ArrayBuffer.empty[PartyIDsGroup]):Option[List[PartyIDsGroup]] = {
    decodeSingle(flds, startPos) match {
      case (pos: Int, None) => if (groups.nonEmpty) Some(groups.toList) else None
      case (pos: Int, grp: Some[PartyIDsGroup]) => decode(flds, pos, groups += grp.get)
    }
  }

  /**
    * @param flds For groups in Fix ordering is VITAL.
    * @param startPos This index into the ordered fields. It HAS to contain the first field of the group
    * @return A Tuple2 holding the next position to read from the fields, and the newly created group
    */
  def decodeSingle(flds: Seq[Tuple2[Int, Any]], startPos:Int):Tuple2[Int,Option[PartyIDsGroup]] = {
    if (!isFirstField(flds(startPos)._1)) (startPos, None)
    else {
      val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(true, flds, startPos)
      validateMandatoryFieldsPresent(myFields)

      if (myFields.nonEmpty) {
        (pos,Some(PartyIDsGroup(myFields.get(PartyIDField.TagId).flatMap(f=>PartyIDField.decode(f)),
          myFields.get(PartyIDSourceField.TagId).flatMap(f=>PartyIDSourceField.decode(f)),
          myFields.get(PartyRoleField.TagId).flatMap(f=>PartyRoleField.decode(f)),
          PtysSubGrpComponent.decode(flds, startPos))))
      } else (startPos, None)
    }
  }
    
}
     