package org.sackfix.fix50sp1

import org.sackfix.field._
import org.sackfix.common.validated.fields.{SfFixGroup, SfGroupDecoder, SfFixFieldsToAscii, SfFixRenderable}
import org.sackfix.common.message.SfRepeatingGroupCountException
import scala.annotation.tailrec
import scala.collection.immutable.HashSet
import scala.collection.mutable.ArrayBuffer


/**
  * Generated by SackFix code generator on 20210314
  * Source specification was read from:
  *   /quickfixj1.6.0/FIX50SP1.xml
  */
case class NestedPartyIDsGroup(nestedPartyIDField:Option[NestedPartyIDField]=None,
                               nestedPartyIDSourceField:Option[NestedPartyIDSourceField]=None,
                               nestedPartyRoleField:Option[NestedPartyRoleField]=None,
                               nstdPtysSubGrpComponent:Option[NstdPtysSubGrpComponent]=None) extends SfFixGroup  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    nestedPartyIDField.foreach(fmt(b,_))
    nestedPartyIDSourceField.foreach(fmt(b,_))
    nestedPartyRoleField.foreach(fmt(b,_))
    nstdPtysSubGrpComponent.foreach(fmt(b,_))
    b
  }

}
     
object NestedPartyIDsGroup extends SfGroupDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    NstdPtysSubGrpComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    NestedPartyIDField.TagId, NestedPartyIDSourceField.TagId, NestedPartyRoleField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    NstdPtysSubGrpComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    NstdPtysSubGrpComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==NestedPartyIDField.TagId 

  // Group version, startPos is the index to the first element of the first repeating group
  @tailrec
  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0, groups:ArrayBuffer[NestedPartyIDsGroup]=ArrayBuffer.empty[NestedPartyIDsGroup]):Option[List[NestedPartyIDsGroup]] = {
    decodeSingle(flds, startPos) match {
      case (pos: Int, None) => if (groups.nonEmpty) Some(groups.toList) else None
      case (pos: Int, grp: Some[NestedPartyIDsGroup]) => decode(flds, pos, groups += grp.get)
    }
  }

  /**
    * @param flds For groups in Fix ordering is VITAL.
    * @param startPos This index into the ordered fields. It HAS to contain the first field of the group
    * @return A Tuple2 holding the next position to read from the fields, and the newly created group
    */
  def decodeSingle(flds: Seq[Tuple2[Int, Any]], startPos:Int):Tuple2[Int,Option[NestedPartyIDsGroup]] = {
    if (!isFirstField(flds(startPos)._1)) (startPos, None)
    else {
      val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(true, flds, startPos)
      validateMandatoryFieldsPresent(myFields)

      if (myFields.nonEmpty) {
        (pos,Some(NestedPartyIDsGroup(myFields.get(NestedPartyIDField.TagId).flatMap(f=>NestedPartyIDField.decode(f)),
          myFields.get(NestedPartyIDSourceField.TagId).flatMap(f=>NestedPartyIDSourceField.decode(f)),
          myFields.get(NestedPartyRoleField.TagId).flatMap(f=>NestedPartyRoleField.decode(f)),
          NstdPtysSubGrpComponent.decode(flds, startPos))))
      } else (startPos, None)
    }
  }
    
}
     