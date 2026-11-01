#include <iostream>
#include <vector>
using namespace std;

int n, k;
vector<int> a;
vector<bool> used;

void Try(int i) {
    for (int j = 1; j <= n; j++) {
        if (!used[j]) {
            a[i] = j;
            used[j] = true;
            if (i == k) {
                for (int l = 1; l <= k; l++) {
                    cout << a[l] << (l == k ? "" : " ");
                }
                cout << endl;
            } else {
                Try(i + 1);
            }
            used[j] = false;
        }
    }
}

int main() {
    if (cin >> n >> k) {
        a.resize(k + 1);
        used.assign(n + 1, false);
        Try(1);
    }
    return 0;
}
