a = []
n = int(input())
for _ in range(n):
    word = input()
    w = list(word)
    if len(w) > 10:
        a.append(f'{w[0]}{len(w)-2}{w[len(w)-1]}')
    else:
        a.append(word)
for i in range(len(a)):
        print(a[i])