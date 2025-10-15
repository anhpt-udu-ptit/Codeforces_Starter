so_bai_giai = 0
n = int(input())

for _ in range(n):
    x, y ,z=map(int, input().split())
    if x + y + z >= 2:
        so_bai_giai += 1

print(so_bai_giai)