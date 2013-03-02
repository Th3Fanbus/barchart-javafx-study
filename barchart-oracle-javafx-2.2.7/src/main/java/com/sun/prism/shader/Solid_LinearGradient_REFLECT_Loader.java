/*    */ package com.sun.prism.shader;
/*    */ 
/*    */ import com.sun.prism.ps.Shader;
/*    */ import com.sun.prism.ps.ShaderFactory;
/*    */ import java.io.InputStream;
/*    */ import java.util.HashMap;
/*    */ 
/*    */ public class Solid_LinearGradient_REFLECT_Loader
/*    */ {
/*    */   public static Shader loadShader(ShaderFactory paramShaderFactory, InputStream paramInputStream)
/*    */   {
/* 43 */     HashMap localHashMap1 = new HashMap();
/* 44 */     localHashMap1.put("colors", Integer.valueOf(0));
/*    */ 
/* 46 */     HashMap localHashMap2 = new HashMap();
/* 47 */     localHashMap2.put("fractions", Integer.valueOf(0));
/* 48 */     localHashMap2.put("gradParams", Integer.valueOf(13));
/* 49 */     localHashMap2.put("perspVec", Integer.valueOf(14));
/* 50 */     localHashMap2.put("offset", Integer.valueOf(12));
/*    */ 
/* 52 */     return paramShaderFactory.createShader(paramInputStream, localHashMap1, localHashMap2, -1, true, true);
/*    */   }
/*    */ }

/* Location:           /home/user1/Temp/jfxrt/jfxrt.jar
 * Qualified Name:     com.sun.prism.shader.Solid_LinearGradient_REFLECT_Loader
 * JD-Core Version:    0.6.2
 */