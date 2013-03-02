/*    */ package com.sun.webpane.webkit.dom;
/*    */ 
/*    */ import org.w3c.dom.css.CSSStyleDeclaration;
/*    */ import org.w3c.dom.css.CSSStyleRule;
/*    */ 
/*    */ public class CSSStyleRuleImpl extends CSSRuleImpl
/*    */   implements CSSStyleRule
/*    */ {
/*    */   CSSStyleRuleImpl(long peer, long contextPeer, long rootPeer)
/*    */   {
/* 10 */     super(peer, contextPeer, rootPeer);
/*    */   }
/*    */ 
/*    */   static CSSStyleRule getImpl(long peer, long contextPeer, long rootPeer) {
/* 14 */     return (CSSStyleRule)create(peer, contextPeer, rootPeer);
/*    */   }
/*    */ 
/*    */   public String getSelectorText()
/*    */   {
/* 20 */     return getSelectorTextImpl(getPeer());
/*    */   }
/*    */   static native String getSelectorTextImpl(long paramLong);
/*    */ 
/*    */   public void setSelectorText(String value) {
/* 25 */     setSelectorTextImpl(getPeer(), value);
/*    */   }
/*    */   static native void setSelectorTextImpl(long paramLong, String paramString);
/*    */ 
/*    */   public CSSStyleDeclaration getStyle() {
/* 30 */     return CSSStyleDeclarationImpl.getImpl(getStyleImpl(getPeer()), this.contextPeer, this.rootPeer);
/*    */   }
/*    */ 
/*    */   static native long getStyleImpl(long paramLong);
/*    */ }

/* Location:           /home/user1/Temp/jfxrt/jfxrt.jar
 * Qualified Name:     com.sun.webpane.webkit.dom.CSSStyleRuleImpl
 * JD-Core Version:    0.6.2
 */