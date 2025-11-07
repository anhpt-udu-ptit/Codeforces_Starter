# 160A_Twins
# https://codeforces.com/problemset/problem/160/A
n = int(input())
a = list(map(int,input().split()))

#Thuật toán: Tham lam (Greedy Algorithm)
#Mô tả thuật toán:
#1. Sắp xếp mảng a theo thứ tự giảm dần.
#2. Tính tổng s của tất cả các phần tử trong mảng a.
#3. Khởi tạo biến t để lưu tổng các phần tử đã chọn, ban đầu t = 0.
#4. Duyệt qua mảng a từ phần tử lớn nhất đến nhỏ nhất:
#   - Cộng phần tử hiện tại vào t.
#   - Kiểm tra nếu t > s - t (tức là tổng các phần tử đã chọn lớn hơn tổng các phần tử còn lại):
#     - In ra số lượng phần tử đã chọn (i + 1) và dừng vòng lặp.
#5. Kết thúc.

#Greedy Algorithm Implementation
#1. Sort the array a in descending order.
#2. Calculate the total sum s of all elements in array a.
#3. Initialize variable t to store the sum of selected elements, initially t = 0.
#4. Iterate through the array a from the largest to the smallest element:
#   - Add the current element to t.
#   - Check if t > s - t (i.e., the sum of selected elements is greater than the sum of the remaining elements):
#     - Print the number of selected elements (i + 1) and break the loop.
#5. End.

#Độ phức tạp thời gian: O(n log n) do việc sắp xếp mảng.
#Độ phức tạp không gian: O(1) vì sử dụng không gian bổ sung không đáng kể.
#Time complexity: O(n log n) due to sorting the array.
#Space complexity: O(1) as it uses negligible additional space.

a.sort(reverse=True)
s = sum(a)
t = 0
for i in range(n):
    t += a[i]
    if t > s - t:
        print(i + 1)
        break