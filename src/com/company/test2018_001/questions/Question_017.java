package com.company.test2018_001.questions;

import java.util.*;
import java.util.Map.Entry;

/*
	题目描述
	大学生足协决定举办全国�?�的大学生足球赛，由每个学校派遣�?支队伍代表该校参赛�?�比赛分区分为几个赛区进行，
	�?终的总决赛中，将有不超过n支队伍参加�?�经过激烈的角�?�，有机会参与�?�决赛的队伍已经决出�?
		协会对比赛的规则进行了调整，以便使得比赛更具有观赏�?��??
		1. 总决赛的参赛队伍为n支，n为偶数；
		2. 进入�?1/2的队伍才有资格进入淘汰赛�?
		3. 队伍按积分排名，具体规则为：胜一场积3分；平一场积1分；负一场积0分�?�队伍首先按积分降序排列，积
		    分相同按�?胜球数降序排列，仍然相同的按进球数降序排列�??
		4. 基于上述规则，尚未出现有排名歧义的情况发生�??
	随着赛程的进行，目前各个队伍对战的结果已经确定了，小B负责确定进入淘汰赛的名单，她向你求助，你能帮她吗�?
	
	输入描述:
		测试数据有多组，每组测试数据的第�?行为�?个整数n�?1≤n�?50），为参与�?�决赛的球队数，随后的n行为球队
		的名字，由不超过30个的大小写拉丁字母构成�?�随后的n*(n-1)/2行为赛事的开展情况，每行的格式为
		name1-name2 num1:num2，表示两支队伍的比分情况�?1≤num1, num2�?100）�?�确保不会有两支队伍同名�?
		也不会出现队伍自己�?�自己比赛的情况，且每场比赛仅出现一次�??
	
	输出描述:
		对每组测试数据，输出n/2行，为按字母序排列的进入淘汰赛的n/2支队伍的名单，每个名字在单独的行中输出�??
	示例1
		输入
			4
			A
			B
			C
			D
			A-B 1:1
			A-C 2:2
			A-D 1:0
			B-C 1:0
			B-D 0:3
			C-D 0:3
			2
			a
			A
			a-A 2:1
		输出
			A
			D
			a
 */
public class Question_017 {
	
	public static void main(String[] args) {
        Scanner sc = new  Scanner(System.in);     
        while(sc.hasNext()) {
        	int n = sc.nextInt();
            sc.nextLine();
            Map<String, Team> map = new HashMap<String, Team>();
            for(int i = 0;i<n;i++) {
            	String team = sc.nextLine();
            	map.put(team, new Team(team));
            }
            for(int i = 0;i<n*(n-1)/2;i++) {
            	String game = sc.nextLine();
            	String[]group = game.split(" ");
            	String[]teams = group[0].split("-");
            	String[]res = group[1].split(":");
            	if(Integer.valueOf(res[0])>Integer.valueOf(res[1])) {
            		map.get(teams[0]).sort = map.get(teams[0]).sort+3;
            		map.get(teams[0]).clean = map.get(teams[0]).clean+Integer.valueOf(res[0])-Integer.valueOf(res[1]);
            		map.get(teams[0]).num = map.get(teams[0]).num+Integer.valueOf(res[0]);
            		map.get(teams[1]).clean = map.get(teams[1]).clean+Integer.valueOf(res[1])-Integer.valueOf(res[0]);
            		map.get(teams[1]).num = map.get(teams[1]).num+Integer.valueOf(res[1]);
            	}else if(Integer.valueOf(res[0])<Integer.valueOf(res[1])) {
            		map.get(teams[1]).sort = map.get(teams[1]).sort+3;
            		map.get(teams[1]).clean = map.get(teams[1]).clean+Integer.valueOf(res[1])-Integer.valueOf(res[0]);
            		map.get(teams[1]).num = map.get(teams[1]).num+Integer.valueOf(res[1]);
            		map.get(teams[0]).clean = map.get(teams[0]).clean+Integer.valueOf(res[0])-Integer.valueOf(res[1]);
            		map.get(teams[0]).num = map.get(teams[0]).num+Integer.valueOf(res[0]);
            	}else {
            		map.get(teams[1]).sort = map.get(teams[1]).sort+1;
            		map.get(teams[1]).num = map.get(teams[1]).num+Integer.valueOf(res[1]);
            		map.get(teams[0]).sort = map.get(teams[0]).sort+1;
            		map.get(teams[0]).num = map.get(teams[0]).num+Integer.valueOf(res[0]);
            	}
            }
            List<Team> list = new ArrayList<Team>();
            Iterator<Entry<String, Team>> iter = map.entrySet().iterator(); 
            while (iter.hasNext()) {
                Entry<String, Team> entry = (Entry<String, Team>) iter.next();         
                list.add((Team) entry.getValue());
            }
            list.sort(new Comparator<Team>() {
    			public int compare(Team o1, Team o2) {
    				if(o2.sort==o1.sort) {
    					if(o2.clean==o1.clean) {
    						return o2.num-o1.num;
    					}else {
    						return o2.clean-o1.clean;
    					}
    				}else {
    					return o2.sort-o1.sort;
    				}
    			}
    		});
            System.out.println(list);
            list = list.subList(0, n/2);
            System.out.println(list);
            list.sort(new Comparator<Team>() {
    			public int compare(Team o1, Team o2) {
    				return o1.name.compareTo(o2.name);
    			}
    		});
            for(int i = 0;i<list.size();i++) {
            	System.out.println(list.get(i).name);
            }
        }
        sc.close();
    }
}
class Team{
	public String name;
	public Integer sort;
	public Integer clean;
	public Integer num;
	Team(String n){
		this.name = n;
		this.sort = 0;
		this.clean = 0;
		this.num = 0;
	}
	@Override
	public String toString() {
		return "Team [name=" + name + ", sort=" + sort + ", clean=" + clean + ", num=" + num + "]";
	}
	
}
