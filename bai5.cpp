#include <iostream>
#include <vector>
using namespace std;

int n, r;
vector<int> a; 
vector<bool> used; 
vector<int> fixed_val;
bool has_solution = false;

void Try(int i) {
    if (i == n) {
        has_solution = true;
        for (int l = 0; l < n; l++) {
            cout << a[l] << (l == n - 1 ? "" : " ");
        }
        cout << endl;
        return;
    }

    // Nếu vị trí này đã được cố định, chỉ việc gán và đi tiếp
    if (fixed_val[i] != 0) {
        a[i] = fixed_val[i];
        Try(i + 1);
    } else {
        // Duyệt các số từ 1 -> n xem số nào chưa dùng
        for (int j = 1; j <= n; j++) {
            if (!used[j]) {
                a[i] = j;
                used[j] = true;
                Try(i + 1);
                used[j] = false;
            }
        }
    }
}

int main() {
    if (cin >> n >> r) {
        a.assign(n, 0);
        used.assign(n + 1, false);
        fixed_val.assign(n, 0); // 0 nghĩa là vị trí chưa bị gắn

        bool possible = true;
        for (int i = 0; i < r; i++) {
            int u, v;
            cin >> u >> v;
            // 2 yêu cầu mâu thuẫn cùng một vị trí
            if (fixed_val[u] != 0 && fixed_val[u] != v) {
                possible = false;
            }
            fixed_val[u] = v;
        }

        if (!possible) {
            cout << 0 << endl;
            return 0;
        }

        // Đánh dấu các giá trị đã dùng, check xem có 2 vị trí nhận cùng 1 giá trị không
        for (int i = 0; i < n; i++) {
            if (fixed_val[i] != 0) {
                if (used[fixed_val[i]]) {
                    possible = false;
                }
                used[fixed_val[i]] = true;
            }
        }

        if (!possible) {
            cout << 0 << endl;
            return 0;
        }

        Try(0);

        if (!has_solution) {
            cout << 0 << endl;
        }
    }
    return 0;
}
