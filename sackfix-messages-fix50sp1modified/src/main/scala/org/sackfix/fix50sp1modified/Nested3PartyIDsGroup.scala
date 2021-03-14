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
case class Nested3PartyIDsGroup(nested3PartyIDField:Option[Nested3PartyIDField]=None,
                                nested3PartyIDSourceField:Option[Nested3PartyIDSourceField]=None,
                                nested3PartyRoleField:Option[Nested3PartyRoleField]=None,
                                nstdPtys3SubGrpComponent:Option[NstdPtys3SubGrpComponent]=None) extends SfFixGroup  with SfFixRenderable with SfFixFieldsToAscii {

  override lazy val fixStr : String = appendFixStr().toString
  override def appendFixStr(b:StringBuilder = new StringBuilder): StringBuilder = format(formatForFix, b)

  override def toString():String = appendStringBuilder().toString()
  def appendStringBuilder(b:StringBuilder = new StringBuilder) : StringBuilder = format(formatForToString, b)

  def format( fmt: ((StringBuilder,SfFixRenderable)=>Unit), b:StringBuilder = new StringBuilder()): StringBuilder = {
    nested3PartyIDField.foreach(fmt(b,_))
    nested3PartyIDSourceField.foreach(fmt(b,_))
    nested3PartyRoleField.foreach(fmt(b,_))
    nstdPtys3SubGrpComponent.foreach(fmt(b,_))
    b
  }

}
     
object Nested3PartyIDsGroup extends SfGroupDecoder {

  override val MandatoryFields = HashSet[Int]()

  override def isMandatoryField(tagId:Int) : Boolean = {
    MandatoryFields.contains(tagId)  || 
    NstdPtys3SubGrpComponent.isMandatoryField(tagId)
  }

  override val OptionalFields = HashSet[Int](
    Nested3PartyIDField.TagId, Nested3PartyIDSourceField.TagId, Nested3PartyRoleField.TagId)

  override def isOptionalField(tagId:Int) : Boolean = {
    OptionalFields.contains(tagId)  || 
    NstdPtys3SubGrpComponent.isOptionalField(tagId)
  }

  override def isFieldOf(tagId:Int) : Boolean = isMandatoryField(tagId) || isOptionalField(tagId)  || 
    NstdPtys3SubGrpComponent.isFieldOf(tagId)

   override lazy val RepeatingGroupsTags = HashSet[Int]()
  
      
  override def isFirstField(tagId:Int) : Boolean = tagId==Nested3PartyIDField.TagId 

  // Group version, startPos is the index to the first element of the first repeating group
  @tailrec
  def decode(flds: Seq[Tuple2[Int, Any]], startPos:Int = 0, groups:ArrayBuffer[Nested3PartyIDsGroup]=ArrayBuffer.empty[Nested3PartyIDsGroup]):Option[List[Nested3PartyIDsGroup]] = {
    decodeSingle(flds, startPos) match {
      case (pos: Int, None) => if (groups.nonEmpty) Some(groups.toList) else None
      case (pos: Int, grp: Some[Nested3PartyIDsGroup]) => decode(flds, pos, groups += grp.get)
    }
  }

  /**
    * @param flds For groups in Fix ordering is VITAL.
    * @param startPos This index into the ordered fields. It HAS to contain the first field of the group
    * @return A Tuple2 holding the next position to read from the fields, and the newly created group
    */
  def decodeSingle(flds: Seq[Tuple2[Int, Any]], startPos:Int):Tuple2[Int,Option[Nested3PartyIDsGroup]] = {
    if (!isFirstField(flds(startPos)._1)) (startPos, None)
    else {
      val (pos, myFields, nextTagPosLookup) = extractMyFieldsAndPopulatePositions(true, flds, startPos)
      validateMandatoryFieldsPresent(myFields)

      if (myFields.nonEmpty) {
        (pos,Some(Nested3PartyIDsGroup(myFields.get(Nested3PartyIDField.TagId).flatMap(f=>Nested3PartyIDField.decode(f)),
          myFields.get(Nested3PartyIDSourceField.TagId).flatMap(f=>Nested3PartyIDSourceField.decode(f)),
          myFields.get(Nested3PartyRoleField.TagId).flatMap(f=>Nested3PartyRoleField.decode(f)),
          NstdPtys3SubGrpComponent.decode(flds, startPos))))
      } else (startPos, None)
    }
  }
    
}
     