package com.jsp.name_pattern.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;
@Service
public class NameService {

	public ModelAndView printNamePattern(String name, int size) {
		int n=size;
		String s=name.toUpperCase();
		List<StringBuilder> list=new ArrayList<StringBuilder>();

		for(int k=0;k<s.length();k++) {
			StringBuilder pattern=new StringBuilder();
			char ch=s.charAt(k);

			if(ch>='A'&&ch<='Z') {
				switch(ch) {
				case 'A':
					for(int i=1;i<=n;i++) {
						for(int j=1;j<=n;j++) {
							if(j==1&&i>1||i==1&&j>1&&j<n||i==n/2+1||j==n&&i>1)
								pattern.append("* ");
							else
								pattern.append("  ");
						}
						pattern.append("</br>");
					}
					break;

				case 'B':
					for(int i=1;i<=n;i++) {
						for(int j=1;j<=n;j++) {
							if(j==1||i==1||i==n||i==n/2+1&&j<n||j==n&&i<=n/2 ||j==n&&i>n/2+1)
								pattern.append("* ");
							else
								pattern.append("  ");
						}
						pattern.append("</br>");
					}
					break;
				case 'C':
					for(int i=1;i<=n;i++) {
						for(int j=1;j<=n;j++) {
							if(i==1&&j>1||i==n&&j>1||j==1&&i>1&&i<n)
								pattern.append("* ");
							else
								pattern.append("  ");
						}
						pattern.append("</br>");
					}
					break;

				case 'D':
					for(int i=1;i<=n;i++) {
						for(int j=1;j<=n;j++) {
							if(j==1||i==1&&j<n||i==n&&j<n||j==n&&i>1&&i<n)
								pattern.append("* ");
							else
								pattern.append("  ");
						}
						pattern.append("</br>");
					}
					break;

				case 'E':
					for(int i=1;i<=n;i++) {
						for(int j=1;j<=n;j++) {
							if(j==1||i==1||i==n||i==n/2+1)
								pattern.append("* ");
							else
								pattern.append("  ");
						}
						pattern.append("</br>");
					}
					break;

				case 'F':
					for(int i=1;i<=n;i++) {
						for(int j=1;j<=n;j++) {

							if(j==1||i==1||i==n/2+1)
								pattern.append("* ");
							else
								pattern.append("  ");
						}
						pattern.append("</br>");
					}
					break;

				case 'G':
					for(int i=1;i<=n;i++) {
						for(int j=1;j<=n;j++) {
							if(j==1&&i>1&&i<n||i==1&&j>1||i==n&&j>1||j==n&&i>n/2+1||i==n/2+1&&j>n/2)
								pattern.append("* ");
							else
								pattern.append("  ");
						}
						pattern.append("</br>");
					}
					break;

				case 'H':
					for(int i=1;i<=n;i++) {
						for(int j=1;j<=n;j++) {
							if(j==1||j==n||i==n/2+1)
								pattern.append("* ");
							else
								pattern.append("  ");
						}
						pattern.append("</br>");
					}
					break;

				case 'I':
					for(int i=1;i<=n;i++) {
						for(int j=1;j<=n;j++) {
							if(i==1||i==n||j==n/2+1)
								pattern.append("* ");
							else
								pattern.append("  ");
						}
						pattern.append("</br>");
					}
					break;

				case 'J':
					for(int i=1;i<=n;i++) {
						for(int j=1;j<=n;j++) {
							if(i==1||j==n/2+1&&i<n||i==n&&j<=n/2)
								pattern.append("* ");
							else
								pattern.append("  ");
						}
						pattern.append("</br>");
					}
					break;

				case 'K':
					for(int i=1;i<2*n;i++) {
						int up=n-i+1,dp=i-6;
						if(i<=n) {
							for(int j=1;j<=up;j++) {
								//						System.out.print("* ");
								if(j==1||j==up) 
									pattern.append("* ");
								else
									pattern.append("  ");
							}

						}else {
							for(int j=1;j<=dp;j++) {
								//						System.out.print("* ");
								if(j==1||j==dp) 
									pattern.append("* ");
								else
									pattern.append("  ");

							}
						}
						pattern.append("</br>");
					}
					break;

				case 'L':
					for(int i=1;i<=n;i++) {
						for(int j=1;j<=n;j++) {
							if(j==1||i==n)
								pattern.append("* ");
							else
								pattern.append("  ");                                      
						}
						pattern.append("</br>");
					}
					break;

				case 'M':
					for(int i=1;i<=n;i++) {
						for(int j=1;j<=n;j++) {
							if(j==1||j==n||i==j&&i<=n/2+1||i+j==n+1&&i<=n/2+1)
								pattern.append("* ");
							else
								pattern.append("  ");
						}
						pattern.append("</br>");
					}
					break;
					//
				case 'N':
					for(int i=1;i<=n;i++) {
						for(int j=1;j<=n;j++) {
							if(j==1||i==j||j==n)
								pattern.append("* ");
							else
								pattern.append("  ");
						}
						pattern.append("</br>");
					}
					break;
					//
				case 'O':
					for(int i=1;i<=n;i++) {
						for(int j=1;j<=n;j++) {
							if(i==1&&j>1&&j<n || j==1&&i>1&&i<n || i==n&&j>1&&j<n ||j==n&&i>1&&i<n)
								pattern.append("* ");
							else
								pattern.append("  ");
						}
						pattern.append("</br>");
					}
					break;
					//
				case 'P':
					for(int i=1;i<=n;i++) {
						for(int j=1;j<=n;j++) {
							if(j==1||i==1&&j<n||i==n/2+1&&j<n||j==n&&i>1&&i<=n/2)
								pattern.append("* ");
							else
								pattern.append("  ");
						}
						pattern.append("</br>");
					}
					break;
					//
				case 'Q':
					for(int i=1;i<=n+1;i++) {
						for(int j=1;j<=n;j++) {
							if(i==1&&j>1&&j<n || i==n&&j>1&&j<n || j==1&&i>1&&i<n || j==n&&i>1&&i<n ||i==j&&i>n/2)
								pattern.append("* ");
							else
								pattern.append("  ");
						}
						for(int j=1;j<=n+1;j++) {
							if(j==n+1&&i==n+1) {
								pattern.append("* ");
							}
						}
						pattern.append("</br>");
					}
					break;
					//
				case 'R':
					for(int i=1;i<=n;i++) {
						for(int j=1;j<=n;j++) {
							if(j==1||i==1&&j<n||i==n/2+1&&j<n|| i==j&&i>n/2||j==n&&i>1&&i<n/2+1)
								pattern.append("* ");
							else
								pattern.append("  ");
						}
						pattern.append("</br>");
					}
					break;
					//
				case 'S':
					for(int i=1;i<=n;i++) {
						for(int j=1;j<=n;j++) {
							if(i==1&&j>1 || j==1&&i<n/2+1&&i>1|| i==n/2+1&&j>1&&j<n ||j==n&&i>n/2+1&&i<n ||i==n&&j<n)
								pattern.append("* ");
							else
								pattern.append("  ");
						}
						pattern.append("</br>");
					}
					break;
					//
				case 'T':
					for(int i=1;i<=n;i++) {
						for(int j=1;j<=n;j++) {
							if(i==1||j==n/2+1)
								pattern.append("* ");
							else
								pattern.append("  ");                         
						}
						pattern.append("</br>");
					}
					break;
					//
				case 'U':
					for(int i=1;i<=n;i++) {
						for(int j=1;j<=n;j++) {
							if(j==1&&i<n||j==n&&i<n||i==n&&j>1&&j<n)
								pattern.append("* ");
							else
								pattern.append("  ");
						}
						pattern.append("</br>");
					}
					break;
					//
				case 'V':
					int st=n,sp=0;
					for(int i=1;i<n;i++) {
						for(int j=1;j<=sp;j++) {
							pattern.append("  ");
						}
						for(int j=1;j<=st;j++) {
							if(j==1||j==st)
								pattern.append("* ");
							else
								pattern.append("  ");
						}
						st=st-2;
						sp++;
						pattern.append("</br>");
					}
					break;
					//
				case 'W':
					for(int i=1;i<=n;i++) {
						for(int j=1;j<=n;j++) {
							if(j==1||j==n||i==j&&i>=n/2+1||i+j==n+1&&i>n/2+1)
								pattern.append("* ");
							else
								pattern.append("  ");
						}
						pattern.append("</br>");
					}
					break;
					//
				case 'X':
					for(int i=1;i<=n;i++) {
						for(int j=1;j<=n;j++) {
							if(i==j||i+j==n+1)
								pattern.append("* ");
							else
								pattern.append("  ");
						}
						pattern.append("</br>");
					}
					break;
					//
				case 'Y':
					for(int i=1;i<=n;i++) {
						for(int j=1;j<=n;j++) {
							if(i==j&&i<=n/2+1||i+j==n+1&&i<=n/2+1 || j==n/2+1&&i>n/2+1)
								pattern.append("* ");
							else
								pattern.append("  ");
						}
						pattern.append("</br>");
					}
					break;

				case 'Z':
					for(int i=1;i<=n;i++) {
						for(int j=1;j<=n;j++) {
							if(i==1||i==n||i+j==n+1)
								pattern.append("* ");
							else
								pattern.append("  ");
						}
						pattern.append("</br>");
					}
					break;
				default:
					pattern.append("</br>");
				}//end Switch
			}//if end
			pattern.append("</br>"); 
			pattern.append("</br>"); 
			list.add(pattern);
		}
		ModelAndView mav=new ModelAndView();
		mav.setViewName("Display.jsp");
		mav.addObject("list",list);
		return mav;	
	}

}
