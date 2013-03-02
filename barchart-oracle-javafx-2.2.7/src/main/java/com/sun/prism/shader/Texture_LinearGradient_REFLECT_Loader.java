/*    */ package com.sun.prism.shader;
/*    */ 
/*    */ import com.sun.prism.ps.Shader;
/*    */ import com.sun.prism.ps.ShaderFactory;
/*    */ import java.io.InputStream;
/*    */ import java.util.HashMap;
/*    */ 
/*    */ public class Texture_LinearGradient_REFLECT_Loader
/*    */ {
/*    */   public static Shader loadShader(ShaderFactory paramShaderFactory, InputStream paramInputStream)
/*    */   {
/* 43 */     HashMap localHashMap1 = new HashMap();
/* 44 */     localHashMap1.put("maskInput", Integer.valueOf(0));
/* 45 */     localHashMap1.put("colors", Integer.valueOf(1));
/*    */ 
/* 47 */     HashMap localHashMap2 = new HashMap();
/* 48 */     localHashMap2.put("fractions", Integer.valueOf(0));
/* 49 */     localHashMap2.put("gradParams", Integer.valueOf(13));
/* 50 */     localHashMap2.put("perspVec", Integer.valueOf(14));
/* 51 */     localHashMap2.put("offset", Integer.valueOf(12));
/*    */ 
/* 53 */     return paramShaderFactory.createShader(paramInputStream, localHashMap1, localHashMap2, 0, true, true);
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jfxrt/jfxrt.jar
 * Qualified Name:     com.sun.prism.shader.Texture_LinearGradient_REFLECT_Loader
 * JD-Core Version:    0.6.2
 */