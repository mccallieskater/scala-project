




package org.example

object App {

  import org.pcap4j.core.PcapNetworkInterface
  import org.pcap4j.core.Pcaps
  import java.net.InetAddress

  val addr: InetAddress = InetAddress.getByName("170.253.143.131")
  val nif: PcapNetworkInterface = Pcaps.getDevByAddress(addr)

  import org.pcap4j.core.PcapHandle
  import org.pcap4j.core.PcapNetworkInterface.PromiscuousMode

  val snapLen = 65536
  val mode = PromiscuousMode.PROMISCUOUS
  val timeout = 10
  val handle: PcapHandle = nif.openLive(snapLen, mode, timeout)

  val packet = handle.getNextPacketEx

  import org.pcap4j.packet.IpV4Packet
  import java.net.Inet4Address

  val ipV4Packet: IpV4Packet = packet.get(classOf[IpV4Packet])
  val srcAddr: Inet4Address = ipV4Packet.getHeader.getSrcAddr
  System.out.println(srcAddr)





  def main(args: Array[String]) {
    println("Hello World!")
  }
}
