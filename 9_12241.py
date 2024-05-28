k=0
for i in open('9_12241.txt'):
    a=[int(x) for x in i.split()]
    p=[x for x in a if a.count(x)==2]
    notp=[x for x in a if a.count(x)==1]
    if len(p)==6 and len(notp)==1 and (max(p)+min(p))/2 < notp[0]:
        k+=1
print(k)
