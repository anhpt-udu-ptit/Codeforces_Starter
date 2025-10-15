#bit++

x = 0

if __name__ == "__main__":
    n = int(input())
    for _ in range(n):
        s = input()
        if s[1] == '+':
            x += 1
        else:
            x -= 1
    print(x)