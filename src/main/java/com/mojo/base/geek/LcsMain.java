package com.mojo.base.geek;

import java.sql.*;

public class LcsMain {
    
    public static void main(String[] args) {
//        int subsequence = new LcsMain().longestCommonSubsequence("abcde", "ace");
//        System.out.println(subsequence);
    
    
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    
    
        String url = "jdbc:mysql://localhost:3306/mojotest?useSSL=false";
        String username = "root";
        String password = "mojomiao";
        Connection conn = null;
    
        try {
            conn = DriverManager.getConnection(url, username, password);
            System.out.println(conn);
            Statement st = null;
            st = conn.createStatement();
            String sql = "select id,name from student";
            ResultSet resultSet = st.executeQuery(sql);
            System.out.println(resultSet);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        
    }
    
    public int longestCommonSubsequence(String text1, String text2) {
        
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m + 1][n + 1];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c1 = text1.charAt(i), c2 = text2.charAt(j);
                if (c1 == c2) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
                
                
            }
        }
        return dp[m][n];
        
    }
}
