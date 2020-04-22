package com.example.bankcollection.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.bankcollection.ui.model.Bank

class HomeViewModel : ViewModel() {

    private val _bank = MutableLiveData<List<Bank>>().apply {
        value = listOf(
            Bank("004", "臺灣銀行", "https://ebank.bot.com.tw/NetBank/NNBank/Default.aspx"),
            Bank("005", "臺灣土地銀行", "https://mybank.landbank.com.tw/DesktopDefault.htm"),
            Bank("006", "合作金庫商業銀行", "https://cobank.tcb-bank.com.tw/home/newIBHome.html"),
            Bank("007", "第一商業銀行", "https://ibank.firstbank.com.tw/NetBank/index103.html"),
            Bank("008", "華南商業銀行", "https://netbank.hncb.com.tw/netbank/servlet/TrxDispatcher?trx=com.lb.wibc.tr,.Login&state=prompt&Recognition=private"),
            Bank("009","彰化商業銀行", "https://www.chb.com.tw/chbnib/faces/login/Login"),
            Bank("011","上海商業儲蓄銀行", "https://ibank.scsb.com.tw/"),
            Bank("012","台北富邦商業銀行", "https://ebank.taipeifubon.com.tw/B2C/common/Index.faces"),
            Bank("013","國泰世華商業銀行", "https://www.cathaybk.com.tw/MyBank"),
            Bank("016","高雄銀行", "https://ibank.bok.com.tw/PIB/common/Login.xhtml"),
            Bank("017","兆豐國際商業銀行", "https://ebank.megabank.com.tw/iibcontent.jsp"),
            Bank("021","花旗（台灣）商業銀行", "https://www.citibank.com.tw/TWGCB/JSO/signon/DisplayUsernameSignon.do"),
            Bank("048","王道商業銀行", "https://www.o-bank.com/retail"),
            Bank("050","臺灣中小企業銀行", "https://portal.tbb.com.tw/tbbportal/"),
            Bank("052","渣打國際商業銀行", "https://ebank.standardchartered.com.tw/scb/public/login?lang=tw"),
            Bank("053","台中商業銀行", "https://ibank.tcbbank.com.tw/PIB/common/Login.faces"),
            Bank("053","台中商業銀行", "https://ibank.tcbbank.com.tw/PIB/common/Login.faces"),
            Bank("054","京城商業銀行", "https://netbank.ktb.com.tw/KTBPIB/WebApi/www/#/home"),
            Bank("081","滙豐（台灣）商業銀行", "https://www.hsbc.com.tw/security/"),
            Bank("101","瑞興商業銀行", "https://ebank.taipeistarbank.com.tw/"),
            Bank("102","華泰商業銀行", "https://netbank.hwataibank.com.tw/NConsumerBank"),
            Bank("103","臺灣新光商業銀行", "https://nbank.skbank.com.tw/"),
            Bank("108","陽信商業銀行", "https://www.esunnybank.com.tw/sunnyNBWeb/index.seam"),
            Bank("118","板信商業銀行", "https://webatm.bop.com.tw/"),
            Bank("147","三信商業銀行", "https://ebank.cotabank.com.tw/eBank/"),
            Bank("803","聯邦商業銀行", "https://mybank.ubot.com.tw/"),
            Bank("805","遠東國際商業銀行", "https://www.feib.com.tw/"),
            Bank("806","元大商業銀行", "https://ebank.yuantabank.com.tw/ib/"),
            Bank("807","永豐商業銀行", "https://mma.sinopac.com/MemberPortal/Member/NextWebLogin.aspx"),
            Bank("808","玉山商業銀行", "https://ebank.esunbank.com.tw/index.jsp"),
            Bank("809","凱基商業銀行", "https://www.kgibank.com/"),
            Bank("810","星展（台灣）商業銀行", "https://internet-banking.dbs.com.tw/cardplus/#/"),
            Bank("812","台新國際商業銀行", "https://my.taishinbank.com.tw/TIBTWWeb/RB00/RB00011001.jsp"),
            Bank("815","日盛國際商業銀行", "https://netbank.jihsunbank.com.tw/"),
            Bank("816","安泰商業銀行", "https://ebanking.entiebank.com.tw/entiebank-web/login"),
            Bank("822","中國信託商業銀行", "https://www.ctbcbank.com/twrbo/zh_tw/index.html")
        )
    }

    val banks: LiveData<List<Bank>> = _bank
}