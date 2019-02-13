package com.company.test2018_001.answers;

import java.util.*;
import java.util.Map.Entry;

/*
	��Ŀ����
	��ѧ����Э�����ٰ�ȫ���ԵĴ�ѧ������������ÿ��ѧУ��ǲһ֧��������У����������������Ϊ�����������У�
	���յ��ܾ����У����в�����n֧����μӡ��������ҵĽ����л�������ܾ����Ķ����Ѿ�������
		Э��Ա����Ĺ�������˵������Ա�ʹ�ñ��������й����ԡ�
		1. �ܾ����Ĳ�������Ϊn֧��nΪż����
		2. ����ǰ1/2�Ķ�������ʸ������̭����
		3. ���鰴�����������������Ϊ��ʤһ����3�֣�ƽһ����1�֣���һ����0�֡��������Ȱ����ֽ������У���
		    ����ͬ����ʤ�����������У���Ȼ��ͬ�İ��������������С�
		4. ��������������δ������������������������
	�������̵Ľ��У�Ŀǰ���������ս�Ľ���Ѿ�ȷ���ˣ�СB����ȷ��������̭�������������������������ܰ�����
	
	��������:
		���������ж��飬ÿ��������ݵĵ�һ��Ϊһ������n��1��n��50����Ϊ�����ܾ����������������n��Ϊ���
		�����֣��ɲ�����30���Ĵ�Сд������ĸ���ɡ�����n*(n-1)/2��Ϊ���µĿ�չ�����ÿ�еĸ�ʽΪ
		name1-name2 num1:num2����ʾ��֧����ıȷ������1��num1, num2��100����ȷ����������֧����ͬ����
		Ҳ������ֶ����Լ�ͨ�Լ��������������ÿ������������һ�Ρ�
	
	�������:
		��ÿ��������ݣ����n/2�У�Ϊ����ĸ�����еĽ�����̭����n/2֧�����������ÿ�������ڵ��������������
	ʾ��1
		����
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
		���
			A
			D
			a
 */
public class Answer_017 {
	
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
