# 160A_Twins
# https://codeforces.com/problemset/problem/160/A
n = int(input())
a = list(map(int,input().split()))

#Thuật toán: Tham lam (Greedy Algorithm)
#Là thuật toán chọn các bước tối ưu cục bộ với hy vọng rằng các lựa chọn này sẽ dẫn đến một giải pháp tối ưu toàn cục.
#Chi tiết:
#1. Sắp xếp mảng a theo thứ tự giảm dần để ưu tiên
#   chọn các đồng xu có giá trị lớn nhất trước.
#2. Tính tổng giá trị tất cả các đồng xu.
#3. Lặp qua mảng đã sắp xếp, cộng dồn giá trị các đồng xu
#   cho đến khi tổng giá trị của các đồng xu đã chọn vượt
#   quá một nửa tổng giá trị ban đầu.
#4. In ra số lượng đồng xu đã chọn.
a.sort(reverse=True)
s = sum(a)
t = 0
for i in range(n):
    t += a[i]
    if t > s - t:
        print(i + 1)
        break