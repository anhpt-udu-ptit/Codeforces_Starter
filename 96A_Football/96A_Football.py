football = list(input())
count = 0
for i in range(len(football) - 1):
    if football[i] == football[i + 1]:
        count += 1
    else:
        count = 0
    if count >= 6:
        print("YES")
        break
else:
    print("NO")