package org.sackfix.fixt11

import org.sackfix.common.validated.fields.SfFixMessageDecoder

/**
  * Generated by SackFix code generator on 20170404
  * Source specification was read from:
  *   /quickfixj1.6.0/FIXT11.xml
  */
object SfMessageFactory {
  def getMessage(msgType:String):Option[SfFixMessageDecoder] = msgType match {
    case "0" => Some(HeartbeatMessage)
    case "1" => Some(TestRequestMessage)
    case "2" => Some(ResendRequestMessage)
    case "3" => Some(RejectMessage)
    case "4" => Some(SequenceResetMessage)
    case "5" => Some(LogoutMessage)
    case "A" => Some(LogonMessage)
    case _ => None
  }
}
